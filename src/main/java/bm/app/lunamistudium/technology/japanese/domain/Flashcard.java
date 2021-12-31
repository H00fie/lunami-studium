package bm.app.lunamistudium.technology.japanese.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Flashcard {

    private Long id;
    private String category;
    private String englishVersion;
    private String japaneseVersion;
    private LocalDateTime createdAt;

    public Flashcard(String category, String englishVersion, String japaneseVersion, LocalDateTime createdAt) {
        this.category = category;
        this.englishVersion = englishVersion;
        this.japaneseVersion = japaneseVersion;
        this.createdAt = createdAt;
    }
}
