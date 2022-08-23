package com.coorder.coorder.menu;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuMapper menuMapper;

    public List<HashMap<String, Object>> getMenu(String storCd) {
        return menuMapper.getMenu(storCd);
    }

    public List<HashMap<String, Object>> getSideMenu(String storCd, String menuCd) {
        return menuMapper.getSideMenu(storCd, menuCd);
    }
}
