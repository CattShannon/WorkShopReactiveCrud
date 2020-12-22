package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public Mono<Void> post(@RequestBody Person personMono) {
        return personService.insert(Mono.just(personMono));
    }

    @GetMapping("/{id}")
    public Mono<Person> getPerson(@PathVariable("id") String id) {
        return Mono.just(new Person());
    }

    @PutMapping
    public Mono<Void> put(@RequestBody Person personMono) {
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public Mono<Person> delPerson(@PathVariable("id") String id) {
        return Mono.empty();
    }

    @GetMapping
    public Flux<Person> list() {
        return personService.listAll();
    }

}
