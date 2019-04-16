package com.sentienz.DataGenerator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import com.sentienz.DataGenerator.models.DataGenTableModel;

public class DataGenMapper implements ResultSetMapper<DataGenTableModel> {

  public DataGenTableModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {

    return new DataGenTableModel(r.getString("id"), r.getLong("created_at"));

  }

}
