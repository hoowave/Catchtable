package com.catchtable.clone.domain.member;

import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.register.TermsRegisterCommand;
import com.catchtable.clone.infrastructure.member.MemberRepository;
import com.catchtable.clone.infrastructure.terms.TermsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final TermsRepository termsRepository;

    @Override
    @Transactional
    public MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                                     TermsRegisterCommand termsRegisterCommand) {
        var initMember = memberRegisterCommand.toEntity();
        memberRepository.memberStore(initMember);
        var initTerms = termsRegisterCommand.toEntity(initMember.getMemberToken());
        termsRepository.termsStore(initTerms);
        // 회원 객체와 약관 객체를 각 각 저장
        return new MemberInfo(initMember);
    }

    @Override
    @Transactional
    public MemberInfo loginMember(MemberLoginCommand memberLoginCommand) {
        var initMember = memberLoginCommand.toEntity();
        Optional<Member> member = memberRepository.login(initMember);

        if (!member.isEmpty()) {
            return new MemberInfo(member.get());
        } else {
            //로그인 실패 시 빈 객체 반환
            return new MemberInfo();
        }

    }
}
