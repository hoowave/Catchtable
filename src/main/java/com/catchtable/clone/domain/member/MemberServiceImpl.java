package com.catchtable.clone.domain.member;

import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.infrastructure.member.MemberStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;

    @Override
    @Transactional
    public MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand) {
        var initMember = memberRegisterCommand.toEntity();
        memberStore.store(initMember);
        return new MemberInfo(initMember);
    }

    @Override
    @Transactional
    public MemberInfo loginMember(MemberLoginCommand memberLoginCommand) {
        var initMember = memberLoginCommand.toEntity();
        Optional<Member> member = memberStore.login(initMember);

        if(!member.isEmpty()){
            return new MemberInfo(member.get());
        }else{
            //로그인 실패 시 빈 객체 반환
            return new MemberInfo();
        }

    }
}
