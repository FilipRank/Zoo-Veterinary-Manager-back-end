package rs.nemamvebsajt.spring_test_project_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rs.nemamvebsajt.spring_test_project_2.model.Animal;
import rs.nemamvebsajt.spring_test_project_2.service.AnimalService;

import java.util.List;

@RestController
@RequestMapping("animal")
@CrossOrigin
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService service;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal) {
        return service.addAnimal(animal);
    }

    @PutMapping(path = "/{id}")
    public Animal modifyAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        return service.modifyAnimalById(id, animal);
    }

//    @DeleteMapping(path = "/{id}")
//    public void softDeleteAnimal(@PathVariable Integer id) {
//        service.softDeleteAnimal(id);
//    }

    @DeleteMapping(path = "/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        service.deleteAnimalById(id);
    }

}
