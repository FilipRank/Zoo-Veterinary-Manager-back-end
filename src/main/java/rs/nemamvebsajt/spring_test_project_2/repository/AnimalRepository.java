package rs.nemamvebsajt.spring_test_project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import rs.nemamvebsajt.spring_test_project_2.model.Animal;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    public List<Animal> findByName(String name);

}
