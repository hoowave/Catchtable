package com.catchtable.clone.infrastructure.member;

import com.catchtable.clone.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberRepository {
    Long memberStore(Member initMember);
    Optional<Member> login(Member initMember);
}
