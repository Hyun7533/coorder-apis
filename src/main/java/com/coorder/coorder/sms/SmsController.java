package com.coorder.coorder.sms;

import com.coorder.coorder.order.OrderController;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class SmsController {

    private final SmsService smsService;

    // 문자메세지 보내기
    @PostMapping("/sendSms")
    public Map<String, Object> sendSms(@Param("userNum")String userNum) {
        return smsService.smsSend(userNum);
    }

    /*
        본인인증
        사용자 번호와 인증번호를 받아서 체크
     */
    @PostMapping("/check")
    public Map<String, Object> check(@Param("userNum")String userNum,
                                     @Param("authNum")String authNum) {
        String getAuthNum = smsService.check(userNum, authNum);
        Map<String, Object> map = new HashMap<>();

        if(authNum.equals(getAuthNum)) {
            map.put("result", "true");
        }else {
            map.put("result", "false");
        }

        return map;
    }

}
