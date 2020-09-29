package com.example.zero.service;

import com.example.zero.dao.PersonDao;
import com.example.zero.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @program: zero
 * @description:
 * @author: Mr.Li
 * @create: 2020-09-09 21:29
 **/

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("h5dao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> selectAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPeopleById(UUID id) {
        return personDao.selectPeopleById(id);
    }

    public int deletePeopleById(UUID id) {
        return personDao.deletePeopleById(id);
    }

    public int updatePeopleById(UUID id, Person person) {
        return personDao.updatePeopleById(id, person);
    }
}
