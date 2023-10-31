package com.catchtable.clone.application.member;

import com.catchtable.clone.domain.member.Member;
import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.MemberInfo;
import com.catchtable.clone.domain.member.MemberService;
import com.catchtable.clone.domain.notify.NotifyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final NotifyService notifyService;

    public MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand){
        var memberInfo = memberService.registerMember(memberRegisterCommand);
        notifyService.sendSms(memberInfo.getPhone(), "회원가입성공");
        return memberInfo;
    }

    public MemberInfo loginMember(MemberLoginCommand memberLoginCommand) {
        var memberInfo = memberService.loginMember(memberLoginCommand);
        return memberInfo;
    }

}