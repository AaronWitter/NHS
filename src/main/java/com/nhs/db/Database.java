package com.nhs.db;

import org.skife.jdbi.v2.sqlobject.SqlQuery;

import java.util.Iterator;

/**
 * Created by Aaron.Witter on 13/01/16.
 */
public interface Database {

  @SqlQuery("select 1 from name_alias")
  Iterator<String> isConnected();

  @SqlQuery("select DB_NAME(db_id())")
  String getUrl();
}
