package com.coorder.coorder.order;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.sms.MessageStatus;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OrderService {


    private final OrderMapper orderMapper;

    public Map<String, Object> orderReq(String storCd, String reqCtnt, String tel, String dlvryTime, String pymntPrice, String pymntCtnt, String dlvrAddr) {

        Map<String, Object> map = new HashMap<>();
        orderMapper.orderReq(storCd, reqCtnt, tel, dlvryTime, pymntPrice, pymntCtnt, dlvrAddr);

        NexmoClient client = NexmoClient.builder()
                .apiKey("90d7f718")
                .apiSecret("Yfbj22hu1NcPo6zU").build();

        TextMessage message = new TextMessage("Vonage APIs",
                "821084060915",
                reqCtnt + ", 010" +
                tel + ", " +
                pymntCtnt + ", " +
                pymntPrice+ ", " +
                dlvrAddr + ", " +
                dlvryTime,
                true
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            map.put("result", "true");
            return map;
        } else {
            map.put("result", response.getMessages().get(0).getErrorText());
            return map;
        }
    }

    public void orderCheck(String tel, String dlvryTime, String pymntPrice, String pymntCtnt) {
        NexmoClient client = NexmoClient.builder().apiKey("90d7f718").apiSecret("Yfbj22hu1NcPo6zU").build();

        TextMessage message = new TextMessage("Vonage APIs",
                "8210" + tel,
                "Coorder 주문 요청이 완료되었습니다." + dlvryTime + ", " + pymntPrice + ", " + pymntCtnt,
                true
        );

        SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);

        if (response.getMessages().get(0).getStatus() == MessageStatus.OK) {
            System.out.println(MessageStatus.OK);
        } else {
            System.out.println(response.getMessages().get(0).getErrorText());
        }

    }
}
