package com.catchtable.clone.domain.member;

import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.register.TermsRegisterCommand;

import java.util.Optional;

public interface MemberService {
    MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                              TermsRegisterCommand termsRegisterCommand);

    MemberInfo loginMember(MemberLoginCommand memberLoginCommand);
}
