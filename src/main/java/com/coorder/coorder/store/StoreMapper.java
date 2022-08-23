package com.coorder.coorder.store;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface StoreMapper {

    @Select("SELECT * FROM T_STOR")
    List<HashMap<String, Blob>> getStore();
}
