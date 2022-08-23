package com.coorder.coorder.menu;

import com.coorder.coorder.order.OrderController;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @GetMapping("/getMenu")
    public List<HashMap<String, Object>> getMenu(@Param("storCd")String storCd) {
        return menuService.getMenu(storCd);
    }

    @GetMapping("/getSideMenu")
    public List<HashMap<String, Object>> getSideMenu(@Param("storCd") String storCd,
                                                     @Param("menuCd") String menuCd) {
        return menuService.getSideMenu(storCd, menuCd);
    }


}
