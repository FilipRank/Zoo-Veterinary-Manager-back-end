package rs.nemamvebsajt.spring_test_project_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.nemamvebsajt.spring_test_project_2.model.Task;
import rs.nemamvebsajt.spring_test_project_2.model.Veterinarian;
import rs.nemamvebsajt.spring_test_project_2.service.VeterinarianService;

import java.util.List;

@RestController
@RequestMapping("veterinarian")
@CrossOrigin
@RequiredArgsConstructor
public class VeterinarianController {

    private final VeterinarianService service;

    @GetMapping(produces = "application/json")
    public List<Veterinarian> getAllVeterinarians() {
        return service.getAllVeterinarians();
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public ResponseEntity<Veterinarian> getVeterinarianById(@PathVariable Integer id) {
        return service.getVeterinarianById(id);
    }

    @PostMapping
    public Veterinarian addVeterinarian(@RequestBody Veterinarian veterinarian) {
        return service.addVeterinarian(veterinarian);
    }

    @PutMapping(path = "/{id}")
    public Veterinarian modifyVeterinarian(@PathVariable Integer id, @RequestBody Veterinarian veterinarian) {
        return service.modifyVeterinarian(id, veterinarian);
    }

    @PutMapping(path = "{veterinarianId}/task/{taskId}")
    public Veterinarian assignTaskToVeterinarian(
            @PathVariable Integer veterinarianId, @PathVariable Integer taskId) {
        return service.assignTaskToVeterinarian(veterinarianId, taskId);
    }

    @DeleteMapping(path = "{veterinarianId}/task/{taskId}")
    public Veterinarian unassignTaskFromVeterinarian(
            @PathVariable Integer veterinarianId, @PathVariable Integer taskId) {
        return service.unassignTaskFromVeterinarian(veterinarianId, taskId);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteVeterinarian(@PathVariable Integer id) {
        service.deleteVeterinarianById(id);
    }

//    @PutMapping(path = "/addtask/{id}")
//    public Veterinarian addTaskToVeterinarian(@PathVariable Integer id, @RequestBody Task task) {
//        return service.addTaskToVeterinarian(id, task);
//    }
}
