package reactive;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Employee extends Person {
    @NotBlank String jobPosition;

    public Employee(Integer id, String name, String jobPosition) {
        super(id, name);
        this.jobPosition = jobPosition;
    }
}
