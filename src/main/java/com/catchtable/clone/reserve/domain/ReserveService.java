package com.catchtable.clone.reserve.domain;

import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import com.catchtable.clone.reserve.domain.info.ShopReserveInfo;

import java.util.List;

public interface ReserveService {
    List<MemberReserveInfo> memberReserveInfoList(String memberToken);

    List<ShopReserveInfo> shopReserveInfoList(String shopToken);

    ReserveInfo reserve(ReserveCommand reserveCommand);
}
