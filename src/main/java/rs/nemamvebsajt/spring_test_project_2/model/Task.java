package rs.nemamvebsajt.spring_test_project_2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Set;

@Entity
@Table(name = "task")
@Getter @Setter
@NoArgsConstructor
@SQLRestriction("deleted_at IS NULL")
public class Task {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String summary;
    private LocalDateTime expectedStartTime;
    private LocalDateTime expectedEndTime;
    private LocalDateTime actualStartTime;
    private LocalDateTime actualEndTime;
    private final LocalDateTime createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    private LocalDateTime updatedAt;
    @JsonIgnore
    private LocalDateTime deletedAt;
    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "veterinarian_task",
            joinColumns = @JoinColumn(name = "task_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "veterinarian_id", nullable = false)
    )
    private Set<Veterinarian> veterinarians;
}
