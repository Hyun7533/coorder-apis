package com.coorder.coorder.order;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface OrderMapper {


    @Insert("INSERT INTO\n" +
            "    T_ORDR\n" +
            "VALUES (\n" +
            "        (\n" +
            "            SELECT NVL(MAX(SEQ) + 1, 0)\n" +
            "            FROM T_ORDR\n" +
            "            WHERE 1=1\n" +
            "            AND STOR_CD = #{storCd}\n" +
            "        ),\n" +
            "        #{storCd},\n" +
            "        #{reqCtnt},\n" +
            "        #{tel},\n" +
            "        #{dlvryTime},\n" +
            "        SYSDATE,\n" +
            "        #{pymntPrice},\n" +
            "        #{pymntCtnt},\n" +
            "       #{dlvrAddr})")
    void orderReq(String storCd,
                                 String reqCtnt,
                                 String tel,
                                 String dlvryTime,
                                 String pymntPrice,
                                 String pymntCtnt,
                                String dlvrAddr);
}
