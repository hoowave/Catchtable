package com.catchtable.clone.reserve.infrastructure;

import com.catchtable.clone.reserve.domain.Reserve;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ReserveDao {
    Long reserveStore(Reserve initReserve);

    int getAvailableReserve(String shopToken, String memberToken, LocalDateTime reserveAt);
    int getAvailablePersonnel(LocalDateTime reserveAt, String shopToken);

    List<MemberReserveInfo> reserveInfoList(String memberToken);
}
