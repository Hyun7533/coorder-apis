package com.coorder.coorder.sms;

import org.apache.ibatis.annotations.*;

import java.util.Map;

@Mapper
public interface SmsMapper {
    @Insert("INSERT INTO T_AUTH (SEQ, AUTH_NUM, DTTM, USER_NUM)\n" +
            "VALUES ((SELECT NVL(MAX(SEQ) + 1, 0) FROM T_AUTH\n" +
            "                  WHERE 1=1\n" +
            "                  and USER_NUM = #{userNum}), #{randomInt}, SYSDATE, #{userNum})")
    public Integer insertNum(@Param("randomInt") Integer randomInt,
                             @Param("userNum") String userNum);

    @Select("SELECT AUTH_NUM FROM T_AUTH\n" +
            "WHERE 1=1\n" +
            "  and USER_NUM = #{userNum}\n" +
            "    and SEQ = (SELECT MAX(SEQ) from T_AUTH where 1=1\n" +
            "                               and USER_NUM = #{userNum})")
    String selUserNum(String userNum);

}
