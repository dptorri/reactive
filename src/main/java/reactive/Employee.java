package reactive;

import javax.validation.constraints.NotBlank;

public class Employee extends Person {
    public Employee(Integer id, String name) {
        super(id, name);
    }

    public String getJobPosition() {
        return jobPosition;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "jobPosition='" + jobPosition + '\'' +
                '}';
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    @NotBlank
    String jobPosition;
}
