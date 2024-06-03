package rs.nemamvebsajt.spring_test_project_2.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import rs.nemamvebsajt.spring_test_project_2.model.Veterinarian;
import rs.nemamvebsajt.spring_test_project_2.repository.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VeterinarianService {

    private final VeterinarianRepository repository;

    public List<Veterinarian> getAllVeterinarians() {
        return repository.findAll();
    }

    public ResponseEntity<Veterinarian> getVeterinarianById(Integer id) {
        return ResponseEntity.of(repository.findById(id));
    }

}
