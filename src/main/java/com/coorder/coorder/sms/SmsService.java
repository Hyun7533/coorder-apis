package com.coorder.coorder.sms;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class SmsService {

    private final SmsMapper smsMapper;

    public Map<String, Object> smsSend(@Param("userNum")String userNum) {

        Map<String, Object> map = new HashMap<>();

        Integer randomInt = ThreadLocalRandom.current().nextInt(100000, 1000000);

        NexmoClient client = NexmoClient.builder()
                .apiKey("90d7f718")
                .apiSecret("Yfbj22hu1NcPo6zU").build();

        TextMessage message = new TextMessage("Vonage APIs",
                "8210" + userNum,
                "Coorder [ " + randomInt + " ]",
                true
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            map.put("result", "true");
            smsMapper.insertNum(randomInt, userNum);
            return map;
        } else {
            map.put("result", response.getMessages().get(0).getErrorText());
            return map;
        }

    }

    public String check(String userNum, String authNum) {
        return smsMapper.selUserNum((userNum));
    }



}
