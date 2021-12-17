package bm.app.lunamistudium.technology.techshorts.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@RequiredArgsConstructor
@Getter
@Setter
public class Techshort {

    private Long id;
    private String header;
    private String category;
    private String content;
    private LocalDateTime createdAt;

    public Techshort(String header, String category, String content, LocalDateTime createdAt) {
        this.header = header;
        this.category = category;
        this.content = content;
        this.createdAt = createdAt;
    }
}
