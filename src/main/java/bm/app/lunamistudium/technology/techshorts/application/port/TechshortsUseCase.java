package bm.app.lunamistudium.technology.techshorts.application.port;

import bm.app.lunamistudium.technology.techshorts.domain.Techshort;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

public interface TechshortsUseCase {

    List<Techshort> findAll();

    Techshort addTechshort(CreateTechshortCommand command);

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
}
