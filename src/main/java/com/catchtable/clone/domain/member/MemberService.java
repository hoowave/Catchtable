package com.catchtable.clone.domain.member;

import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;

import java.util.Optional;

public interface MemberService {
    MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand);

    MemberInfo loginMember(MemberLoginCommand memberLoginCommand);
}
