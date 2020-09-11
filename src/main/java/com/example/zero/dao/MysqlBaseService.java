package com.example.zero.dao;

import com.example.zero.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @program: zero
 * @description:
 * @author: Mr.Li
 * @create: 2020-09-11 22:26
 **/

@Repository("mysql")
public class MysqlBaseService implements PersonDao{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MysqlBaseService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public List<Person> selectAllPeople() {
        return jdbcTemplate.query("SELECT id, name FROM person ",
                    ((resultSet, i) ->
                    new Person(UUID.fromString(resultSet.getString("id")),
                            resultSet.getString("name"))));
    }

    @Override
    public Optional<Person> selectPeopleById(UUID id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("SELECT id, name FROM person WHERE id = ?",
                new Object[]{id},
                ((resultSet, i) -> new Person(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name")))));
    }

    @Override
    public int deletePeopleById(UUID id) {
        return 0;
    }

    @Override
    public int updatePeopleById(UUID id, Person person) {
        return 0;
    }
}
