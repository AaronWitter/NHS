package com.nhs.model.mappers;

import com.nhs.model.Person;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Aaron.Witter on 13/01/16.
 */
public class PersonMapper implements ResultSetMapper<Person>
{
  public Person map(int index, ResultSet r, StatementContext ctx) throws SQLException
  {
    return new Person(r.getLong("Person_UID"), r.getString("Forename1"), r.getString("Surname"),
        r.getString("Date_of_Birth"));
  }
}