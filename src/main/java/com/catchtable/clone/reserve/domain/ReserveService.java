package com.catchtable.clone.reserve.domain;

import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;

import java.util.List;

public interface ReserveService {
    List<MemberReserveInfo> reserveInfoList(String memberToken);

    ReserveInfo reserve(ReserveCommand reserveCommand);
}
