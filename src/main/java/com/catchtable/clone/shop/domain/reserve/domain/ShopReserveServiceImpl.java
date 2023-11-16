package com.catchtable.clone.shop.domain.reserve.domain;

import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReserveMenuInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReserveMenuRegisterCommand;
import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReservePersonnelInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReservePersonnelRegisterCommand;
import com.catchtable.clone.shop.domain.reserve.infrastructure.ShopReserveDao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ShopReserveServiceImpl implements ShopReserveService {
    private final ShopReserveDao reserveRepository;

    @Override
    @Transactional
    public ShopReserveMenuInfo menuRegister(ShopReserveMenuRegisterCommand reserveMenuRegisterCommand) {
        var initReserveMenu = reserveMenuRegisterCommand.toEntity();
        reserveRepository.reserveMenuStore(initReserveMenu);
        return new ShopReserveMenuInfo(initReserveMenu);
    }

    @Override
    @Transactional
    public ShopReservePersonnelInfo personnelRegister(ShopReservePersonnelRegisterCommand reservePersonnelRegisterCommand) {
        var initReservePersonnel = reservePersonnelRegisterCommand.toEntity();
        reserveRepository.reservePersonnelStore(initReservePersonnel);
        return new ShopReservePersonnelInfo(initReservePersonnel);
    }
}
