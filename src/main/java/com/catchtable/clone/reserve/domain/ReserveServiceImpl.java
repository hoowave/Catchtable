package com.catchtable.clone.reserve.domain;

import com.catchtable.clone.reserve.domain.command.ReserveCommand;
import com.catchtable.clone.reserve.domain.info.MemberReserveInfo;
import com.catchtable.clone.reserve.domain.info.ReserveInfo;
import com.catchtable.clone.reserve.infrastructure.ReserveDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveServiceImpl implements ReserveService{
    private final ReserveDao reserveDao;
    @Override
    public List<MemberReserveInfo> reserveInfoList(String memberToken) {
        List<MemberReserveInfo> reserveInfolist = reserveDao.reserveInfoList(memberToken);
        return reserveInfolist;
    }

    @Override
    @Transactional
    public ReserveInfo reserve(ReserveCommand reserveCommand) {
        System.out.println("reserveCommand = " + reserveCommand);
        int availablePersonnel = reserveDao.getAvailablePersonnel(reserveCommand.getReserveAt(), reserveCommand.getShopToken());
        if (availablePersonnel < reserveCommand.getPersonnel()) {
            // 가게 기준 현재 예약 인원보다 예약하려는 인원이 많은지 체크
            return new ReserveInfo(-2);
        }
        var initReserve = reserveCommand.toEntity();
        System.out.println("initReserve = " + initReserve);
        //reserveDao.reserveStore(initReserve);
        return new ReserveInfo(initReserve);
    }
}
