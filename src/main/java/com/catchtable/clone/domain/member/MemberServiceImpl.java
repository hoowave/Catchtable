package com.catchtable.clone.domain.member;

import com.catchtable.clone.infrastructure.member.MemberStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberStore memberStore;

    @Override
    @Transactional
    public MemberInfo registerMember(MemberCommand memberCommand) {
        var initMember = memberCommand.toEntity();
        Member member = memberStore.store(initMember);
        System.out.println("member = " + member);
        return new MemberInfo(member);
    }
}
