package com.sentienz.DataGenerator.store;

import org.skife.jdbi.v2.DBI;
import com.sentienz.DataGenerator.dao.DataGenDAO;
import lombok.Getter;

public class DAOHolder {
  
  @Getter
  private static DBI jdbiHolder;
  @Getter
  private static DataGenDAO dataGenDao;
  
  public static void init(DBI jdbi) {

    jdbiHolder=jdbi;
    dataGenDao = jdbi.onDemand(DataGenDAO.class);

  }

}
