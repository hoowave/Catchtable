package com.catchtable.clone.members.infrastructure;

import com.catchtable.clone.members.domain.notify.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotifyExecutor implements NotifyService {
    @Override
    public void sendSms(String phone, String content) {
        System.out.println(phone + " 으로 " + content + " SMS 전송");
    }
}
