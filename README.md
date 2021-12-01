# reactive
Reactive examples with Mono and Flux


### 0. Create a Create project from CLI
#### add Reactor and graalvm
```
mn create-app --features=reactor reactive --build=gradle --lang=java   
```

### 1. Run it
```
./gradlew tasks run 
```

### 2. Create the Person controller
#### 2.1 Create the Person model
```
Person {
 id: Integer
 name: String
}
```
#### 2.2 Implement methods for adding and finding all persons by id
```
POST /persons
GET /persons/{id}
```
#### 2.3 Add persons with bash script
```
-rw-r--r--   1 user  190 Dec  1 12:51 addPerson.sh
chmod +x addPerson.sh   
-rwxr-xr-x   1 user  190 Dec  1 12:51 addPerson.sh

❯ sh addPerson.sh
{"id":1,"name":"Kate"}%    

❯ curl -X GET "http://localhost:8080/persons/1"
{"id":1,"name":"Kate"}%           
                                                     
❯ curl -X GET "http://localhost:8080/persons/2"
{"message":"Not Found", ...Page Not Found"}]}}%
```

#### 3. Add Mono controller with some creation examples
```
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

```