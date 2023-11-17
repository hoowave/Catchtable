package com.catchtable.clone.reserve.infrastructure;

import com.catchtable.clone.reserve.domain.Reserve;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Mapper
public interface ReserveDao {
    Long reserveStore(Reserve initReserve);

    int getAvailablePersonnel(LocalDateTime reserveAt, String shopToken);

    List<MemberReserveInfo> reserveInfoList(String memberToken);
}
