package de.aittr.auto_spring;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutoService {

    private AutoRepository repository;


    public AutoService(AutoRepository repository) {
        this.repository = repository;
    }

    public List<Auto> getAllAutos() {
        return repository.findAll();
    }

    public void sevaAuto(Auto auto) {
        repository.save(auto);
    }

    public Optional<Auto> getAutoById(Long id) {
        Optional<Auto> auto = repository.findById(id);
        return auto;
    }
}
