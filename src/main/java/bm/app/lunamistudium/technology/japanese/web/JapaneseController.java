package bm.app.lunamistudium.technology.japanese.web;

import bm.app.lunamistudium.technology.japanese.application.port.JapaneseUseCase;
import bm.app.lunamistudium.technology.japanese.domain.Flashcard;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/flashcards")
@RestController
@AllArgsConstructor
public class JapaneseController {

    private final JapaneseUseCase japaneseUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Flashcard> getAll() {
        return japaneseUseCase.findAll();
    }
    
}
