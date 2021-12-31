package bm.app.lunamistudium.technology.techshorts.web;

import bm.app.lunamistudium.technology.techshorts.application.port.TechshortsUseCase;
import bm.app.lunamistudium.technology.techshorts.application.port.TechshortsUseCase.CreateTechshortCommand;
import bm.app.lunamistudium.technology.techshorts.domain.Techshort;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import static bm.app.lunamistudium.technology.techshorts.application.port.TechshortsUseCase.*;

@RequestMapping("/api/techshorts")
@RestController
@AllArgsConstructor
public class TechshortsController {

    private final TechshortsUseCase techshortsUseCase;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Techshort> getAll() {
        return techshortsUseCase.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addTechshort(@RequestBody RestTechshortCommand command) {
        Techshort techshort = techshortsUseCase.addTechshort(command.toCreateCommand());
        URI uri = createTechshortUri(techshort);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        techshortsUseCase.removeById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateTechshort(@PathVariable Long id, @RequestBody RestTechshortCommand command) {
        UpdateTechshortResponse response = techshortsUseCase.updateTechshort(command.toUpdateCommand(id));
        if (!response.isSuccess()) {
            String message = String.join(", ", response.getErrors());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
    }

    @Data
    private static class RestTechshortCommand {
        private String header;
        private String category;
        private String content;
        private LocalDateTime createdAt;

        CreateTechshortCommand toCreateCommand() {
            return new CreateTechshortCommand(header, category, content, createdAt);
        }

        UpdateTechshortCommand toUpdateCommand(Long id) {
            return new UpdateTechshortCommand(id, header, category, content, createdAt);
        }
    }

    private URI createTechshortUri(Techshort techshort) {
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/" + techshort.getId().toString())
                .build()
                .toUri();
    }
}
