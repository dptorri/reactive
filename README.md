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
````
POST /persons
GET /persons/{id}
```




