package reactive;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import reactor.core.publisher.Mono;

import java.util.function.Function;

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


}
