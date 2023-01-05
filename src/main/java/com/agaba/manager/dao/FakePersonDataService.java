package com.agaba.manager.dao;

import com.agaba.manager.models.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataService implements  PersonDao {

    private  static   List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(), person.getEmail()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
       return DB;
    }

    @Override
    public boolean deletePersonById(UUID id) {

        if(!IsExist(id)) return  false;
            DB.remove(DB.stream().filter(person -> person.getId().equals(id)).findFirst().get());
            return true;
    }

    @Override
    public Person selectPersonById(UUID id) {

        if(!IsExist(id)) return  null;
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst().get();
    }

    private boolean IsExist(UUID id) {
        return  DB.stream().anyMatch(person -> person.getId().equals(id));
    }
}
