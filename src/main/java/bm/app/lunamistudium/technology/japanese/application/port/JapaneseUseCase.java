package bm.app.lunamistudium.technology.japanese.application.port;

import bm.app.lunamistudium.technology.japanese.domain.Flashcard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public interface JapaneseUseCase {

    List<Flashcard> findAll();

    Flashcard addFlashcard(CreateFlashcardCommand command);

    void removeById(Long id);

    UpdateFlashcardResponse updateFlashcard(UpdateFlashcardCommand command);

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

    @Value
    @Builder
    @AllArgsConstructor
    class UpdateFlashcardCommand {
        Long id;
        String category;
        String englishVersion;
        String japaneseVersion;
        LocalDateTime createdAt;

        public Flashcard updateFlashcard(Flashcard flashcard) {
            if (category != null) {
                flashcard.setCategory(category);
            }
            if (englishVersion != null) {
                flashcard.setEnglishVersion(englishVersion);
            }
            if (japaneseVersion != null) {
                flashcard.setJapaneseVersion(japaneseVersion);
            }
            if (createdAt != null) {
                flashcard.setCreatedAt(createdAt);
            }
            return flashcard;
        }
    }

    @Value
    class UpdateFlashcardResponse {
        public static UpdateFlashcardResponse SUCCESS = new UpdateFlashcardResponse(true, Collections.emptyList());
        boolean success;
        List<String> errors;
    }

}
