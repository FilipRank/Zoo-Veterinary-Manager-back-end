package rs.nemamvebsajt.spring_test_project_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.nemamvebsajt.spring_test_project_2.model.Task;
import rs.nemamvebsajt.spring_test_project_2.repository.AnimalRepository;
import rs.nemamvebsajt.spring_test_project_2.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final AnimalService animalService;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task newTask, Integer animalId) {
        Task task = new Task();
        task.setName(newTask.getName());
        task.setAnimal(animalService.getAnimalById(animalId).getBody());
        task.setSummary(newTask.getSummary());
        task.setExpectedEndTime(newTask.getExpectedEndTime());
        task.setExpectedStartTime(newTask.getExpectedStartTime());
        return repository.save(task);
    }

    public void deleteTask(Integer id) {
        repository.deleteById(id);
    }

}
