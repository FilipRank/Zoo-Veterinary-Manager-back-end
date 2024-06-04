package rs.nemamvebsajt.spring_test_project_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "animal")
@Getter @Setter
@NoArgsConstructor
@SQLRestriction("deleted_at IS NULL")
public class Animal {

    @Id
    @Column(name = "animal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String species;
    @Column(columnDefinition = "TEXT")
    private String healthStatus;
    private final LocalDateTime createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;
}
