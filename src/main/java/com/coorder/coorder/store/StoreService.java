package com.coorder.coorder.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper storeMapper;

    public List<HashMap<String, Blob>> getStore() {
        return storeMapper.getStore();
    }
}
