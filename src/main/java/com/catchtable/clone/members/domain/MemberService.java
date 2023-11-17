package com.catchtable.clone.members.domain;

import com.catchtable.clone.members.domain.info.MemberInfo;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.members.domain.command.MemberLoginCommand;
import com.catchtable.clone.members.domain.command.MemberRegisterCommand;
import com.catchtable.clone.members.domain.command.TermsRegisterCommand;
import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface MemberService {

    MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                              TermsRegisterCommand termsRegisterCommand);

    MemberInfo loginMember(MemberLoginCommand memberLoginCommand);

    void loginCheck(HttpSession session);
}
