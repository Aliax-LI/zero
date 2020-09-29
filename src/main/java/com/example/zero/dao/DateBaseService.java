package com.example.zero.dao;

import com.example.zero.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @program: zero
 * @description:
 * @author: Mr.Li
 * @create: 2020-09-09 21:26
 **/

@Repository("h5dao")
public class DateBaseService implements PersonDao {

    private static List<Person> DB = new ArrayList<>();


    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPeopleById(UUID id) {
        return DB.stream()
                .filter(person -> id.equals(person.getId()))
                .findFirst();
    }

    @Override
    public int deletePeopleById(UUID id) {
        Optional<Person> person = selectPeopleById(id);
        if (ObjectUtils.isEmpty(person)) {
            return 0;
        }
        DB.remove(person.get());
        return 1;
    }

    @Override
    public int updatePeopleById(UUID id, Person person) {
        return selectPeopleById(id)
                .map(people -> {
                    int index = DB.indexOf(people);
                    if (index >= 0) {
                        DB.set(index, new Person(id, person.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }
}
