package com.catchtable.clone.application.member;

import com.catchtable.clone.domain.member.MemberCommand;
import com.catchtable.clone.domain.member.MemberInfo;
import com.catchtable.clone.domain.member.MemberService;
import com.catchtable.clone.domain.notify.NotifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final NotifyService notifyService;

    public MemberInfo registerMember(MemberCommand memberCommand){
        var memberInfo = memberService.registerMember(memberCommand);
        //notifyService.sendSms(memberInfo.getPhone(), "회원가입성공 SMS");
        return memberInfo;
    }

}
