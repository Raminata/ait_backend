package de.aittr.auto_spring;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AutoRepository {

    private static List<Auto> list = new ArrayList<>(List.of(
            new Auto(1l, "B14K08", "Opel"),
            new Auto(2l, "B14V08", "BMW"),
            new Auto(3l, "B14T08", "Audi"),
            new Auto(4l, "B14U08", "Opel")
    ));

    public List<Auto> findAll() {
        return list;
    }

    public Auto save(Auto auto) {
        list.add(auto);
        return auto;
    }

    public Optional<Auto> findById(Long id) {
        return list.stream()
                .filter(a->a.getId().equals(id))
                .findFirst();
    }
}


//autos/2