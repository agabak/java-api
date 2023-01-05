package com.agaba.manager.dao;

import com.agaba.manager.models.Person;

import java.util.List;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default  int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return  insertPerson(id,person);
    }

    List<Person>  selectAllPeople();

    boolean deletePersonById(UUID id);

    Person selectPersonById(UUID id);

}
