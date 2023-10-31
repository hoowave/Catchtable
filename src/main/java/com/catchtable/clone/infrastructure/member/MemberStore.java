package com.catchtable.clone.infrastructure.member;

import com.catchtable.clone.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberStore {
    Long store(Member initMember);
    Optional<Member> login(Member initMember);
}
