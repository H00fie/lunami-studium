package bm.app.lunamistudium.technology.japanese.web;

import bm.app.lunamistudium.technology.japanese.application.port.JapaneseUseCase;
import bm.app.lunamistudium.technology.japanese.application.port.JapaneseUseCase.CreateFlashcardCommand;
import bm.app.lunamistudium.technology.japanese.domain.Flashcard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import static bm.app.lunamistudium.technology.japanese.application.port.JapaneseUseCase.*;

@RequestMapping("/api/flashcards")
@RestController
@AllArgsConstructor
public class JapaneseController {

    private final JapaneseUseCase japaneseUseCase;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Flashcard> getAll() {
        return japaneseUseCase.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> addFlashcard(@RequestBody RestFlashCardCommand command) {
        Flashcard flashcard = japaneseUseCase.addFlashcard(command.toCreateCommand());
        URI uri = createFlashcardUri(flashcard);
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        japaneseUseCase.removeById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateFlashcard(@PathVariable Long id, @RequestBody RestFlashCardCommand command) {
        UpdateFlashcardResponse response = japaneseUseCase.updateFlashcard(command.toUpdateCommand(id));
        if (!response.isSuccess()) {
            String message = String.join(", ", response.getErrors());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
        }
    }

    @Data
    private static class RestFlashCardCommand {
        private String category;
        private String englishVersion;
        private String japaneseVersion;
        private LocalDateTime createdAt;

        CreateFlashcardCommand toCreateCommand() {
            return new CreateFlashcardCommand(category, englishVersion, japaneseVersion, createdAt);
        }

        UpdateFlashcardCommand toUpdateCommand(Long id) {
            return new UpdateFlashcardCommand(id, category, englishVersion, japaneseVersion, createdAt);
        }
    }

    private URI createFlashcardUri(Flashcard flashcard) {
        return ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/" + flashcard.getId().toString())
                .build()
                .toUri();
    }
}
