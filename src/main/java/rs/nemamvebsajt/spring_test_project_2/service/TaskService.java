package rs.nemamvebsajt.spring_test_project_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.nemamvebsajt.spring_test_project_2.model.Task;
import rs.nemamvebsajt.spring_test_project_2.repository.TaskRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

}
