package com.sentienz.DataGenerator.health;

import com.codahale.metrics.health.HealthCheck;

public class DataGeneratorHealthCheck extends HealthCheck{
  
  @Override
  protected Result check() throws Exception {
    return Result.healthy();
  }

}
