package rs.nemamvebsajt.spring_test_project_2.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ErrorModel {

    private String name;
    private String message;
    private String path;

}
