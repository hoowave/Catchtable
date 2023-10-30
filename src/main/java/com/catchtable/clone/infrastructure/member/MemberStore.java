package com.catchtable.clone.infrastructure.member;

import com.catchtable.clone.domain.member.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberStore {
    Member store(Member initMember);
}
