package bm.app.lunamistudium.technology.techshorts.infrastructure;

import bm.app.lunamistudium.technology.techshorts.domain.Techshort;
import bm.app.lunamistudium.technology.techshorts.domain.TechshortsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class MemoryTechshortsRepository implements TechshortsRepository {

    private final Map<Long, Techshort> storage = new ConcurrentHashMap<>();
    private final AtomicLong ID_NEXT_VALUE = new AtomicLong(0L);

    @Override
    public List<Techshort> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Techshort save(Techshort techshort) {
        if (techshort.getId() != null) {
            storage.put(techshort.getId(), techshort);
        } else {
            long nextId = nextId();
            techshort.setId(nextId);
            storage.put(nextId, techshort);
        }
        return techshort;
    }

    @Override
    public void deleteById(Long id) {
        storage.remove(id);
    }

    @Override
    public Optional<Techshort> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    private long nextId() {
        return ID_NEXT_VALUE.getAndIncrement();
    }
}
