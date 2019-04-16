package com.sentienz.DataGenerator.conf;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;

@Data
public class DataGenConf extends Configuration {

  private int counter;
  
  private String prefix;

  @NotNull
  @Valid
  @JsonProperty
  private DataSourceFactory dataSourceFactory = new DataSourceFactory();

}
