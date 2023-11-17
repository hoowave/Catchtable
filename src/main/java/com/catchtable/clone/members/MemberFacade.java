package com.catchtable.clone.members;

import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.members.domain.command.MemberLoginCommand;
import com.catchtable.clone.members.domain.command.MemberRegisterCommand;
import com.catchtable.clone.members.domain.info.MemberInfo;
import com.catchtable.clone.members.domain.MemberService;
import com.catchtable.clone.members.domain.command.TermsRegisterCommand;
import com.catchtable.clone.members.domain.notify.NotifyService;
import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final NotifyService notifyService;

    public MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                                     TermsRegisterCommand termsRegisterCommand) {
        var memberInfo = memberService.registerMember(memberRegisterCommand, termsRegisterCommand);
        notifyService.sendSms(memberInfo.getPhone(), "회원가입성공");
        return memberInfo;
    }

    public MemberInfo loginMember(MemberLoginCommand memberLoginCommand) {
        var memberInfo = memberService.loginMember(memberLoginCommand);
        return memberInfo;
    }

    public void loginCheck(HttpSession session){
        memberService.loginCheck(session);
    }

}