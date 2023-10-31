package com.catchtable.clone.infrastructure.notify;

import com.catchtable.clone.domain.notify.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NotifyExecutor implements NotifyService {
    @Override
    public void sendSms(String phone, String content) {
        System.out.println("SMS 전송");
    }
}
