package com.catchtable.clone.infrastructure.member;

import com.catchtable.clone.domain.member.Member;
import com.catchtable.clone.domain.member.MemberReserveInfo;
import com.catchtable.clone.domain.member.reserve.Reserve;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberRepository {
    Long memberStore(Member initMember);

    Optional<Member> login(Member initMember);

    Optional<String> getShopIdToShopToken(String shopName);

    Long reserveStore(Reserve initReserve);

    int getAvailablePersonnel(LocalDateTime reserveAt, String shopToken);

    List<MemberReserveInfo> reserveInfoList(String memberToken);

}
