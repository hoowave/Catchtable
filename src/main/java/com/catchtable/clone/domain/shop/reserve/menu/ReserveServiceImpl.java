package com.catchtable.clone.domain.shop.reserve.menu;

import com.catchtable.clone.domain.shop.reserve.menu.register.ReserveMenuRegisterCommand;
import com.catchtable.clone.domain.shop.reserve.personnel.ReservePersonnelInfo;
import com.catchtable.clone.domain.shop.reserve.personnel.register.ReservePersonnelRegisterCommand;
import com.catchtable.clone.infrastructure.shop.reserve.ReserveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReserveServiceImpl implements ReserveService {
    private final ReserveRepository reserveRepository;

    @Override
    @Transactional
    public ReserveMenuInfo menuRegister(ReserveMenuRegisterCommand reserveMenuRegisterCommand) {
        var initReserveMenu = reserveMenuRegisterCommand.toEntity();
        reserveRepository.reserveMenuStore(initReserveMenu);
        return new ReserveMenuInfo(initReserveMenu);
    }

    @Override
    @Transactional
    public ReservePersonnelInfo personnelRegister(ReservePersonnelRegisterCommand reservePersonnelRegisterCommand) {
        var initReservePersonnel = reservePersonnelRegisterCommand.toEntity();
        reserveRepository.reservePersonnelStore(initReservePersonnel);
        return new ReservePersonnelInfo(initReservePersonnel);
    }
}
