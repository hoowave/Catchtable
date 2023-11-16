package com.catchtable.clone.shop.domain.reserve.domain.command;

import com.catchtable.clone.shop.domain.reserve.domain.ShopReservePersonnel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Time;

@Getter
@Builder
@ToString
public class ShopReservePersonnelRegisterCommand {
    private final String shopToken;
    private final Time reserveAt;
    private final int personnel;

    public ShopReservePersonnel toEntity() {
        return ShopReservePersonnel.builder()
                .shopToken(shopToken)
                .reserveAt(reserveAt)
                .personnel(personnel)
                .build();
    }
}
