package reactive;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {

    List<Employee> employees = new ArrayList<>();

    @Post("employees")
    public Person saveEmployee(@Body @Valid Employee employee) {
        employee.setId(employees.size() + 1);
        employees.add(employee);

        return employee;
    }

    @Get("employees/{id}")
    public Optional<Employee> findById(@NotNull Integer id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }
}
