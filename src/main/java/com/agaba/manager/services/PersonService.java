package com.agaba.manager.services;

import com.agaba.manager.dao.PersonDao;
import com.agaba.manager.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private  final PersonDao _personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao _personDao) {
        this._personDao = _personDao;
    }

    public  int addPerson(Person person) {
        return _personDao.insertPerson(person);
    }

    public List<Person> selectAllPeople() {
        return  _personDao.selectAllPeople();
    }

    public  boolean deletePerson(UUID id) {
        return  _personDao.deletePersonById(id);
    }

    public  Person selectPersonById(UUID id){
        return  _personDao.selectPersonById(id);
    }
}
