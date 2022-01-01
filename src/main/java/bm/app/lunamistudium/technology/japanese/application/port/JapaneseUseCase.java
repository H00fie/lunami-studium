package bm.app.lunamistudium.technology.japanese.application.port;

import bm.app.lunamistudium.technology.japanese.domain.Flashcard;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface JapaneseUseCase {

    List<Flashcard> findAll();

    Flashcard addFlashcard(CreateFlashcardCommand command);

    void removeById(Long id);

    @Value
    class CreateFlashcardCommand {
        String category;
        String englishVersion;
        String japaneseVersion;
        LocalDateTime createdAt;

        public Flashcard toFlashcard() {
            return new Flashcard(category, englishVersion, japaneseVersion, createdAt);
        }
    }

}
