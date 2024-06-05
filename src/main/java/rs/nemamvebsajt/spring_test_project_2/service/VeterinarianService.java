package rs.nemamvebsajt.spring_test_project_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.nemamvebsajt.spring_test_project_2.error.ResourceNotFoundException;
import rs.nemamvebsajt.spring_test_project_2.model.Task;
import rs.nemamvebsajt.spring_test_project_2.model.Veterinarian;
import rs.nemamvebsajt.spring_test_project_2.repository.TaskRepository;
import rs.nemamvebsajt.spring_test_project_2.repository.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinarianService {

    private final VeterinarianRepository repository;
    private final TaskService taskService;

    public List<Veterinarian> getAllVeterinarians() {
        return repository.findAll();
    }

    public ResponseEntity<Veterinarian> getVeterinarianById(Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

    public Veterinarian addVeterinarian(Veterinarian newVeterinarian) {
        Veterinarian veterinarian = new Veterinarian();
        veterinarian.setName(newVeterinarian.getName());
        veterinarian.setSurname(newVeterinarian.getSurname());
        veterinarian.setIdCardCode(newVeterinarian.getIdCardCode());
        return repository.save(veterinarian);
    }

    public Veterinarian modifyVeterinarian(Integer id, Veterinarian newVeterinarian) {
        Veterinarian veterinarian = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No such veterinarian with id: " + id));
        veterinarian.setName(newVeterinarian.getName());
        veterinarian.setSurname(newVeterinarian.getSurname());
        veterinarian.setIdCardCode(newVeterinarian.getIdCardCode());
        return repository.save(veterinarian);
    }

    public void deleteVeterinarianById(Integer id) {
        repository.deleteById(id);
    }

    public Veterinarian assignTaskToVeterinarian(Integer veterinarianId, Integer taskId) {
        Veterinarian veterinarian = repository.findById(veterinarianId)
                .orElseThrow(() -> new ResourceNotFoundException("No such veterinarian with id: " + veterinarianId));
        veterinarian.getTasks().add(taskService.getTaskById(taskId).getBody());
        return repository.save(veterinarian);
    }

    public Veterinarian unassignTaskFromVeterinarian(Integer veterinarianId, Integer taskId) {
        Veterinarian veterinarian = repository.findById(veterinarianId)
                .orElseThrow(() -> new ResourceNotFoundException("No such veterinarian with id: " + veterinarianId));
        veterinarian.getTasks().remove(taskService.getTaskById(taskId).getBody());
        return repository.save(veterinarian);
    }

}
