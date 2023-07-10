package de.aittr.auto;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class AutoRepository {

    public static List<Auto> list = new ArrayList<>(
            List.of(new Auto("VW", 8080)
                    , new Auto("Audi", 0001)
                    , new Auto("BMW", 0007)
                    , new Auto("Toyota", 0005)
                    , new Auto("Mustang", 0003)));

    public List<Auto> findAll() {
        return list;
    }

    public Optional<Auto> findById(Long id) {
        return list.stream()
                .filter(u -> u.getId()
                        .equals(id))
                .findFirst();
    }
}
