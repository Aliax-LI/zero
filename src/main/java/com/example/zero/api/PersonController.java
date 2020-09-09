package com.example.zero.api;

import com.example.zero.model.Person;
import com.example.zero.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * @program: zero
 * @description:
 * @author: Mr.Li
 * @create: 2020-09-09 21:31
 **/
@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public int addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @GetMapping
    public List<Person> selectAllPeople() {
        return personService.selectAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPeopleById(@PathVariable("id") UUID id) {
        return personService.getPeopleById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deletePeopleById(@PathVariable UUID id) {
        return personService.deletePeopleById(id);
    }

    @PutMapping(path = "{id}")
    public int updatePeopleById(@PathVariable("id") UUID id, @RequestBody Person person) {
        return personService.updatePeopleById(id, person);
    }
}
