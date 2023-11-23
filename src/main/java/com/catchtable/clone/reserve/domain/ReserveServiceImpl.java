package com.catchtable.clone.reserve.domain;

import com.catchtable.clone.common.response.ErrorCode;
import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import com.catchtable.clone.reserve.domain.info.ShopReserveInfo;
import com.catchtable.clone.reserve.infrastructure.ReserveDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveServiceImpl implements ReserveService {
    private final ReserveDao reserveDao;

    @Override
    public List<MemberReserveInfo> memberReserveInfoList(String memberToken) {
        List<MemberReserveInfo> reserveInfoList = reserveDao.memberReserveInfoList(memberToken);
        return reserveInfoList;
    }

    @Override
    public List<ShopReserveInfo> shopReserveInfoList(String shopToken) {
        List<ShopReserveInfo> reserveInfoList = reserveDao.shopReserveInfoList(shopToken);
        return reserveInfoList;
    }

    @Override
    @Transactional
    public ReserveInfo reserve(ReserveCommand reserveCommand) {
        int availableReserve = reserveDao.getAvailableReserve(reserveCommand.getShopToken(), reserveCommand.getMemberToken(), reserveCommand.getReserveAt());
        if (availableReserve > 0) {
            //이미 해당 가게 동일 시간에 예약되어 있는지 체크
            throw new ReserveException(ErrorCode.RESERVE_NOT_AVAILABLE_RESERVE);
        }
        int availablePersonnel = reserveDao.getAvailablePersonnel(reserveCommand.getReserveAt(), reserveCommand.getShopToken());
        if (availablePersonnel < reserveCommand.getPersonnel()) {
            // 가게 기준 현재 예약 인원보다 예약하려는 인원이 많은지 체크
            throw new ReserveException(ErrorCode.RESERVE_NOT_AVAILABLE_PERSONNEL);
        }
        var initReserve = reserveCommand.toEntity();
        reserveDao.reserveStore(initReserve);
        return new ReserveInfo(initReserve);
    }
}
