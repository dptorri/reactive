package reactive;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Controller("/mock")
public class Mockery {

    Mono<Person> mockPerson() {
        final Person person = new Person(4 ,"Jane");
        return Mono.just(person);
    }

    Mono<List<Person>> mockPersons() {
        final List<Person> personList = new ArrayList<>();

        final Person person1 = new Person(1, "Fran");
        final Person person2 = new Person(2, "Jocy");
        final Person person3 = new Person(3, "Kim");

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        return Mono.just(personList);
    }

    @Get("/persons")
    public Mono<List<Person>> getPersonList() {
        return this.mockPersons();
    }

    @Get("/employees")
    public Mono<List<Employee>> getEmployeeList() {
        final List<Employee> employeeList = new ArrayList<>();

        final var tempPersons = this.mockPersons().block();

        for(Person person: tempPersons) {
            //TODO: Iterate and create employee list
        }

        return Mono.just(employeeList);
    }
}
