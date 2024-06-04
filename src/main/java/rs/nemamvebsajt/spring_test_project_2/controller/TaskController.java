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

    @PostMapping(path = "/animal/{animalId}")
    public Task addTaskWithAnimal(@RequestBody Task task, @PathVariable Integer animalId) {
        return service.addTask(task, animalId);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteTask(@PathVariable Integer id) {
        service.deleteTask(id);
    }

}
