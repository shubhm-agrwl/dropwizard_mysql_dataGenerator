package com.sentienz.DataGenerator.dao;

import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.sentienz.DataGenerator.models.DataGenTableModel;

@RegisterMapper(DataGenMapper.class)
public interface DataGenDAO {
  
  @SqlUpdate("insert into dataGenTable (id,created_at) values (:id,:createdAt)")
  void insert(@BindBean DataGenTableModel dataGenTableModel);

  @SqlQuery("select * from dataGenTable where id = :id")
  List<DataGenTableModel> findByDeviceId(@Bind("id") String deviceId);
  
  @SqlQuery("truncate dataGenTable")
  int delete();

}
