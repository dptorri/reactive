package reactive;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

@Controller("/monon")
public class Monon {

    @Get("/monoString")
    public Mono<String> monoString(){
        return Mono.just("Mono strong");
    }

    @Get("/monoEmpty")
    public Mono<String> monoEmpty(){
        return Mono.empty();
    }

    String helloWord() { return "Hello World"; }

    @Get("/monoFromCallable")
    public Mono<?> monoFromCallable(){
        return Mono.fromCallable(this::helloWord);
    }

    Mono<Person> mockPerson() {
        final Person person = new Person(4 ,"Jane");
        return Mono.just(person);
    }

    @Get("/monoMockPerson")
    public Mono<Person> monoMockPerson() {
            return Mono.fromCallable(this::mockPerson).block();
        }

    @Get("/monoMockPerson2")
    public Mono<Person> monoMockPerson2() {
        return monoMockPerson();
    }

}
