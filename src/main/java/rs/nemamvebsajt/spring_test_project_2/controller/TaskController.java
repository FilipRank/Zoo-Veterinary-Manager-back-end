package rs.nemamvebsajt.spring_test_project_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.nemamvebsajt.spring_test_project_2.model.Task;
import rs.nemamvebsajt.spring_test_project_2.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Integer id) {
        return service.getTaskById(id);
    }

    @PutMapping(path = "{id}/animal/{animalId}")
    public Task modifyTask(@RequestBody Task task, @PathVariable Integer id, @PathVariable Integer animalId) {
        return service.modifyTask(task, id, animalId);
    }

    @PostMapping(path = "/animal/{animalId}")
    public Task addTaskWithAnimal(@RequestBody Task task, @PathVariable Integer animalId) {
        return service.addTask(task, animalId);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
    }

}
