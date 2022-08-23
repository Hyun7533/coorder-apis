package com.coorder.coorder.order;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/orderReq")
    public Map<String, Object> orderReq(@Param("storCd")String storCd,              // 가게 코드
                            @Param("reqCtnt") String reqCtnt,           // 요청 사항
                            @Param("tel") String tel,                   // 사용자 폰 번호
                            @Param("dlvryTime") String dlvryTime,       // 배달 시간대 (1:00, 2:00)
                            @Param("pymntPrice") String pymntPrice,     // 결제 가격
                            @Param("pymntCtnt") String pymntCtnt,
                            @Param("dlvrAddr") String dlvrAddr) {     // 결제 내용 무엇을 결제했냐
        orderService.orderCheck(tel,  dlvryTime,  pymntPrice,  pymntCtnt);

        return orderService.orderReq(storCd, reqCtnt, tel, dlvryTime, pymntPrice, pymntCtnt, dlvrAddr);
    }
}
