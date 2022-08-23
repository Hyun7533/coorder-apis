package com.coorder.coorder.store;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/getStore")
    public List<HashMap<String, Blob>> getMenu() {
        return storeService.getStore();
    }
}
