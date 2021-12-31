package bm.app.lunamistudium.technology.techshorts.domain;

import java.util.List;
import java.util.Optional;

public interface TechshortsRepository {

    List<Techshort> findAll();

    Techshort save(Techshort techshort);

    void deleteById(Long id);

    Optional<Techshort> findById(Long id);


}
