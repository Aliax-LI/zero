package com.example.zero.dao;

import com.example.zero.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @program: zero
 * @description:
 * @author: Mr.Li
 * @create: 2020-09-09 21:22
 **/
public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPeopleById(UUID id);

    int deletePeopleById(UUID id);

    int updatePeopleById(UUID id, Person person);
}
