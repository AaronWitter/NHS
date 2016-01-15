package com.nhs.application;

import com.nhs.configuration.WebportalConfiguration;
import com.nhs.db.Database;
import com.nhs.db.PersonDAO;
import com.nhs.health.DatabaseHealthCheck;
import com.nhs.resources.PersonResource;
import com.nhs.resources.TestResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

public class WebportalApplication extends Application<WebportalConfiguration> {

    public static void main(final String[] args) throws Exception {
        new WebportalApplication().run(args);
    }


    @Override
    public void initialize(final Bootstrap<WebportalConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/assets", "/assets"));
        bootstrap.addBundle(new MigrationsBundle<WebportalConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(WebportalConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

    }

    @Override
    public void run(final WebportalConfiguration configuration,
                    final Environment environment) {

    final DBIFactory factory = new DBIFactory();
    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory()
        , "mysql");

    final PersonDAO dao = jdbi.onDemand(PersonDAO.class);

    final Database database = jdbi.onDemand(Database.class);

    environment.healthChecks().register("database", new DatabaseHealthCheck(database));

    environment.jersey().register(TestResource.class);
        environment.jersey().register(new PersonResource(dao));

    }
}
