package com.sentienz.DataGenerator;

import org.skife.jdbi.v2.DBI;
import com.sentienz.DataGenerator.conf.DataGenConf;
import com.sentienz.DataGenerator.health.DataGeneratorHealthCheck;
import com.sentienz.DataGenerator.models.DataGenTableModel;
import com.sentienz.DataGenerator.store.DAOHolder;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DataGen extends Application<DataGenConf> {
  public static void main(String[] args) throws Exception {
    System.out.println("DropWizard Data Generator!");
    new DataGen().run(args);
  }

  @Override
  public void run(DataGenConf configuration, Environment environment) throws Exception {
    final DBIFactory factory = new DBIFactory();
    final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "mysql");
    DAOHolder.init(jdbi);

    for (int i = 0; i < configuration.getCounter(); i++) {
      DataGenTableModel dataGenTableModel =
          new DataGenTableModel(configuration.getPrefix() + "_" + i, System.currentTimeMillis());
      DAOHolder.getDataGenDao().insert(dataGenTableModel);
    }
    log.info("Inserted "+ configuration.getCounter() +"records");

    environment.healthChecks().register("Data-Generator Health Check",
        new DataGeneratorHealthCheck());

    // adding shutdown hook
    Runtime runtime = Runtime.getRuntime();
    runtime.addShutdownHook(new ShutDownHook());

  }

  class ShutDownHook extends Thread {

    @Override
    public void run() {
      log.info("Running Shutdown Hook");
      try {
        System.out.println("check");
        DAOHolder.getDataGenDao().delete();

      } catch (Exception e) {
        log.error("Error occured while running shutdown hook.", e);
      }

    }
  }

}
