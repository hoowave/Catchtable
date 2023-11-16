package com.catchtable.clone.members.infrastructure;

import com.catchtable.clone.members.domain.Member;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.Reserve;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberDao {
    Long memberStore(Member initMember);

    Optional<Member> login(Member initMember);
}
