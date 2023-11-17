package com.catchtable.clone.members.domain;

import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.members.domain.info.MemberInfo;
import com.catchtable.clone.members.domain.command.MemberLoginCommand;
import com.catchtable.clone.members.domain.command.MemberRegisterCommand;
import com.catchtable.clone.members.domain.command.TermsRegisterCommand;
import com.catchtable.clone.members.infrastructure.MemberDao;
import com.catchtable.clone.members.infrastructure.TermsDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDao memberDao;
    private final TermsDao termsDao;

    @Override
    @Transactional
    public MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                                     TermsRegisterCommand termsRegisterCommand) {
        var initMember = memberRegisterCommand.toEntity();
        memberDao.memberStore(initMember);
        var initTerms = termsRegisterCommand.toEntity(initMember.getMemberToken());
        termsDao.termsStore(initTerms);
        // 회원 객체와 약관 객체를 각 각 저장
        return new MemberInfo(initMember);
    }

    @Override
    @Transactional
    public MemberInfo loginMember(MemberLoginCommand memberLoginCommand) {
        var initMember = memberLoginCommand.toEntity();
        Optional<Member> member = memberDao.login(initMember);

        if (!member.isEmpty()) return new MemberInfo(member.get());
        else throw new MemberException(ErrorCode.MEMBER_NOT_FOUND);
    }

    @Override
    public void loginCheck(HttpSession session) {
        System.out.println(session.getAttribute("member"));
        if (session.getAttribute("member") == null) {
            throw new MemberException(ErrorCode.MEMBER_NEED_LOGIN);
        }
    }
}
