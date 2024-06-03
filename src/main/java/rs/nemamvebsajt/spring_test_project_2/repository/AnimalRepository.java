package rs.nemamvebsajt.spring_test_project_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.nemamvebsajt.spring_test_project_2.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
