package rs.nemamvebsajt.spring_test_project_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import rs.nemamvebsajt.spring_test_project_2.error.ResourceNotFoundException;
import rs.nemamvebsajt.spring_test_project_2.model.Animal;
import rs.nemamvebsajt.spring_test_project_2.repository.AnimalRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;

    public List<Animal> getAllAnimals() {
        return repository.findAll();
    }

    public ResponseEntity<Animal> getAnimalById(Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    public List<Animal> getAnimalsByName(String name) {
        return repository.findByName(name);
    }

    public Animal addAnimal(Animal newAnimal) {
        Animal animal = new Animal();
        animal.setName(newAnimal.getName());
        animal.setSpecies(newAnimal.getSpecies());
        animal.setHealthStatus(newAnimal.getHealthStatus());
        return repository.save(animal);
    }

    public Animal modifyAnimalById(Integer id, Animal modifiedAnimal) {
        Animal animal = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No such animal with id: " + id));

        animal.setName(modifiedAnimal.getName());
        animal.setSpecies(modifiedAnimal.getSpecies());
        animal.setHealthStatus(modifiedAnimal.getHealthStatus());
        animal.setUpdatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));

        return repository.save(animal);
    }

    public void deleteAnimalById(Integer id) {
        repository.deleteById(id);
    }

//    public void softDeleteAnimal(Integer id) {
//        Animal animal = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No such animal with id: " + id));
//
//        animal.setDeletedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
//
//        repository.save(animal);
//    }

}
