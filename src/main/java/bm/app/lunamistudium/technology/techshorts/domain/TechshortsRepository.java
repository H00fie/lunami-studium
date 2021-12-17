package bm.app.lunamistudium.technology.techshorts.domain;

import java.util.List;

public interface TechshortsRepository {

    List<Techshort> findAll();

    Techshort save(Techshort techshort);


}
