package ru.polishuk.springcourse.config.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.polishuk.springcourse.config.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PERSON_COUNT;


    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate=jdbcTemplate;
    }
    public List<Person> index(){

      return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id){

        return jdbcTemplate.query("SELECT*FROM Person WHERE id=?", new Object[]{id},new BeanPropertyRowMapper<>(Person.class)).
                stream().findAny().orElse(null);
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES (1,?,?,?)",person.getName(),person.getMail(),person.getAge());

    }

    public void update(int id, Person person) {
        jdbcTemplate.update("UPDATE Person SET name=?,age=?,mail=? WHERE id=?",person.getName(),person.getAge(),person.getMail(),id);

    }

    public void delete(int id) {

        jdbcTemplate.update("DELETE FROM Person WHERE id=?",id);

    }
}


