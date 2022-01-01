package bm.app.lunamistudium.technology.japanese.domain;

import java.util.List;
import java.util.Optional;

public interface JapaneseRepository {

    List<Flashcard> findAll();

    Flashcard save(Flashcard flashcard);

    void deleteById(Long id);

    Optional<Flashcard> findById(Long id);
}
