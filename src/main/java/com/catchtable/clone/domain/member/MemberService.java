package com.catchtable.clone.domain.member;

import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.register.TermsRegisterCommand;
import com.catchtable.clone.domain.member.reserve.ReserveCommand;
import com.catchtable.clone.domain.member.reserve.ReserveInfo;

import java.util.List;

public interface MemberService {

    List<MemberReserveInfo> reserveInfoList(String memberToken);

    ReserveInfo reserve(ReserveCommand reserveCommand);

    MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                              TermsRegisterCommand termsRegisterCommand);

    MemberInfo loginMember(MemberLoginCommand memberLoginCommand);
}
