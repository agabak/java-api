package com.agaba.manager.api;

import com.agaba.manager.models.Person;
import com.agaba.manager.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/person")
@RestController
public class PersonController {

    private  final PersonService _personService;

    @Autowired
    public PersonController(PersonService _personService) {
        this._personService = _personService;
    }

    @PostMapping
    public  void addPerson(@RequestBody Person person) {
        _personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return  _personService.selectAllPeople();
    }

    @GetMapping(path = "{id}")
    public  Person getPerson(@PathVariable("id") UUID id) {
        return  _personService.selectPersonById(id);
    }

    @DeleteMapping(path = "{id}")
    public  void deletePerson(@PathVariable("id") UUID id) {
        _personService.deletePerson(id);
    }
}