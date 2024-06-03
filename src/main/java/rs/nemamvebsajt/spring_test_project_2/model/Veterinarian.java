package rs.nemamvebsajt.spring_test_project_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Entity
@Table(name = "veterinarian")
@Getter @Setter
@NoArgsConstructor
@SQLRestriction("deleted_at IS NULL")
public class Veterinarian {

    @Id
    @Column(name = "veterinarian_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 6, unique = true)
    private String idCardCode;
    private String name;
    private String surname;
    private final LocalDateTime createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;
    @ManyToMany
    @JoinTable(
            name = "veterinarian_task",
            joinColumns = @JoinColumn(name = "veterinarian_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "task_id", nullable = false)
    )
    private Set<Task> tasks;

}
