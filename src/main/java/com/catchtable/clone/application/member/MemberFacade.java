package com.catchtable.clone.application.member;

import com.catchtable.clone.domain.member.MemberReserveInfo;
import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.MemberInfo;
import com.catchtable.clone.domain.member.MemberService;
import com.catchtable.clone.domain.member.register.TermsRegisterCommand;
import com.catchtable.clone.domain.notify.NotifyService;
import com.catchtable.clone.domain.member.reserve.ReserveCommand;
import com.catchtable.clone.domain.member.reserve.ReserveInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberFacade {
    private final MemberService memberService;
    private final NotifyService notifyService;

    public List<MemberReserveInfo> reserveInfo(String memberToken) {
        var reserveInfoList = memberService.reserveInfoList(memberToken);
        return reserveInfoList;
    }

    public ReserveInfo reserve(ReserveCommand reserveCommand) {
        var reserveInfo = memberService.reserve(reserveCommand);
        return reserveInfo;
    }

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

}