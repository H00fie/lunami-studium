package bm.app.lunamistudium.technology.techshorts.application.port;

import bm.app.lunamistudium.technology.techshorts.domain.Techshort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public interface TechshortsUseCase {

    List<Techshort> findAll();

    Techshort addTechshort(CreateTechshortCommand command);

    void removeById(Long id);

    UpdateTechshortResponse updateTechshort(UpdateTechshortCommand command);

    @Value
    class CreateTechshortCommand {
        String header;
        String category;
        String content;
        LocalDateTime createdAt;

        public Techshort toTechshort() {
            return new Techshort(header, category, content, createdAt);
        }
    }

    @Value
    @Builder
    @AllArgsConstructor
    class UpdateTechshortCommand {
        Long id;
        String header;
        String category;
        String content;
        LocalDateTime createdAt;

        public Techshort updateFields(Techshort techshort) {
            if (header != null) {
                techshort.setHeader(header);
            }
            if (category != null) {
                techshort.setCategory(category);
            }
            if (content != null) {
                techshort.setContent(content);
            }
            if (createdAt != null) {
                techshort.setCreatedAt(createdAt);
            }
            return techshort;
        }
    }

    @Value
    class UpdateTechshortResponse {
        public static UpdateTechshortResponse SUCCESS = new UpdateTechshortResponse(true, Collections.emptyList());
        boolean success;
        List<String> errors;
    }
}
