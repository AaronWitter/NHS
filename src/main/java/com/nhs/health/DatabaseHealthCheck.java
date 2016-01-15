package com.nhs.health;

import com.codahale.metrics.health.HealthCheck;
import com.nhs.db.Database;

/**
 * Created by Aaron.Witter on 13/01/16.
 */
public class DatabaseHealthCheck extends HealthCheck {
  private final Database database;

  public DatabaseHealthCheck(Database database) {
    this.database = database;
  }

  @Override
  protected Result check() throws Exception {
    if (database.isConnected().next() != null) {
      return Result.healthy();
    } else {
      return HealthCheck.Result.unhealthy("Cannot connect to " + database.getUrl());
    }
  }
}