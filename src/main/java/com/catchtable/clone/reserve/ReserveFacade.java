package com.catchtable.clone.reserve;

import com.catchtable.clone.reserve.domain.ReserveService;
import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveFacade {
    private final ReserveService reserveService;

    public List<MemberReserveInfo> reserveInfo(String memberToken) {
        var reserveInfoList = reserveService.reserveInfoList(memberToken);
        return reserveInfoList;
    }

    public ReserveInfo reserve(ReserveCommand reserveCommand) {
        var reserveInfo = reserveService.reserve(reserveCommand);
        return reserveInfo;
    }
}
