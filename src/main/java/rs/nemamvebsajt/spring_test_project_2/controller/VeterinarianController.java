package rs.nemamvebsajt.spring_test_project_2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
}
