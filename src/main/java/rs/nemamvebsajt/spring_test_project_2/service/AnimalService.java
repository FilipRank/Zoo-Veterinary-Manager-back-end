package rs.nemamvebsajt.spring_test_project_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.nemamvebsajt.spring_test_project_2.error.ResourceNotFoundException;
import rs.nemamvebsajt.spring_test_project_2.model.Animal;
import rs.nemamvebsajt.spring_test_project_2.repository.AnimalRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;

    public List<Animal> getAllAnimals() {
        return repository.findAll();
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

//    public void softDeleteAnimal(Integer id) {
//        Animal animal = repository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("No such animal with id: " + id));
//
//        animal.setDeletedAt(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS));
//
//        repository.save(animal);
//    }

    public void deleteAnimalById(Integer id) {
        repository.deleteById(id);
    }

}
