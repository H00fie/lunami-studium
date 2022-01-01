package bm.app.lunamistudium.technology.japanese.infrastructure;

import bm.app.lunamistudium.technology.japanese.domain.Flashcard;
import bm.app.lunamistudium.technology.japanese.domain.JapaneseRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryJapaneseRepository implements JapaneseRepository {

    private final Map<Long, Flashcard> shelf = new ConcurrentHashMap<>();
    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(0L);

    @Override
    public List<Flashcard> findAll() {
        return new ArrayList<>(shelf.values());
    }

    @Override
    public Flashcard save(Flashcard flashcard) {
        if (flashcard.getId() == null) {
            flashcard.setId(createTheId());
        }
        shelf.put(flashcard.getId(), flashcard);
        return flashcard;
    }

    @Override
    public void deleteById(Long id) {
        shelf.remove(id);
    }

    @Override
    public Optional<Flashcard> findById(Long id) {
        return Optional.ofNullable(shelf.get(id));
    }

    private long createTheId() {
        return ID_NEXT_VALUE.getAndIncrement();
    }
}
