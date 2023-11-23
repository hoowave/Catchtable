package com.catchtable.clone.reserve;

import com.catchtable.clone.reserve.domain.ReserveService;
import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import com.catchtable.clone.reserve.domain.info.ShopReserveInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveFacade {
    private final ReserveService reserveService;

    public List<ShopReserveInfo> shopReserveInfoList(String shopToken){
        var shopReserveInfoList = reserveService.shopReserveInfoList(shopToken);
        return shopReserveInfoList;
    }

    public List<MemberReserveInfo> memberReserveInfoList(String memberToken) {
        var memberReserveInfoList = reserveService.memberReserveInfoList(memberToken);
        return memberReserveInfoList;
    }

    public ReserveInfo reserve(ReserveCommand reserveCommand) {
        var reserveInfo = reserveService.reserve(reserveCommand);
        return reserveInfo;
    }
}
