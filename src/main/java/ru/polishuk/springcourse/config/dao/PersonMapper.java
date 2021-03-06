package ru.polishuk.springcourse.config.dao;

import org.springframework.jdbc.core.RowMapper;
import ru.polishuk.springcourse.config.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setMail(resultSet.getString("mail"));
        person.setAge(resultSet.getInt("age"));
        person.setName(resultSet.getString("name"));
        return person;
    }
}
