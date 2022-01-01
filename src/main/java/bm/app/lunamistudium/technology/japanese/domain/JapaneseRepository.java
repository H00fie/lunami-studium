package bm.app.lunamistudium.technology.japanese.domain;

import java.util.List;

public interface JapaneseRepository {

    List<Flashcard> findAll();

    Flashcard save(Flashcard flashcard);

    void deleteById(Long id);
}
