package com.nhs.db;

import com.nhs.model.Person;
import com.nhs.model.mappers.PersonMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 * Created by Aaron.Witter on 13/01/16.
 */
public interface PersonDAO{
  @SqlUpdate("create table something (id int primary key, name varchar(100))")
  void createSomethingTable();

  @SqlUpdate("insert into something (id, name) values (:id, :name)")
  void insert(@Bind("id") int id, @Bind("name") String name);

  @Mapper(PersonMapper.class)
  @SqlQuery("select * from name_alias where person_uid = :id")
  Person findNameById(@Bind("id") int id);
}

