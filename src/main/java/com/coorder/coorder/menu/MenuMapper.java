package com.coorder.coorder.menu;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MenuMapper {

    @Select(
        "select A.STOR_CD, A.STOR_NM, B.MENU_CD, B.MENU_NM, B.MENU_DETL, B.PRICE, B.MENU_TYPE, B.IS_MAIN\n" +
                "from T_STOR A, T_MENU B\n" +
                "where 1=1\n" +
                "  and A.STOR_CD = B.STOR_CD\n" +
                "and A.STOR_CD = #{storCd}"
    )
    public List<HashMap<String, Object>> getMenu(String storCd);

    @Select("select MENU_CD, S_MENU_CD, S_MENU_NM, PRICE, S_MENU_TYPE, IS_COUNT\n" +
            "from T_MENU_S\n" +
            "where 1=1\n" +
            "and STOR_CD = #{storCd}\n" +
            "and MENU_CD = #{menuCd}")
    public List<HashMap<String, Object>> getSideMenu(String storCd, String menuCd);

}
