package reactive;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import reactor.core.publisher.Mono;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller("/")
public class PersonController {
    List<Person> persons = new ArrayList<>();

    @Get
    public HttpResponse<String> index() {
        return HttpResponse.ok("project: reactive running on http://localhost:8080");
    }


    @Post("persons")
    public Person savePerson(@Body Person person) {
        person.setId(persons.size() + 1);
        persons.add(person);

        return person;
    }

    @Get("persons/{id}")
    public Optional<Person> findById(@NotNull Integer id) {
        return persons.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
}
