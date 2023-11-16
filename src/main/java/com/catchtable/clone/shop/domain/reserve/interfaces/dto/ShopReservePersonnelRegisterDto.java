package com.catchtable.clone.shop.domain.reserve.interfaces.dto;

import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReservePersonnelInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReservePersonnelRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShopReservePersonnelRegisterDto {

    @Getter
    @Setter
    @ToString
    public static class request {
        private String shopToken;
        private String reserveAt;
        private int personnel;

        public ShopReservePersonnelRegisterCommand toCommand(String shopToken) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime rTime = LocalTime.parse(reserveAt, formatter);
            return ShopReservePersonnelRegisterCommand.builder()
                    .shopToken(shopToken)
                    .reserveAt(Time.valueOf(rTime))
                    .personnel(personnel)
                    .build();
        }

    }

    @Getter
    @ToString
    public static class response {
        private final String shopToken;
        private final Time reserveAt;
        private final int personnel;

        public response(ShopReservePersonnelInfo reservePersonnelInfo) {
            this.shopToken = reservePersonnelInfo.getShopToken();
            this.reserveAt = reservePersonnelInfo.getReserveAt();
            this.personnel = reservePersonnelInfo.getPersonnel();
        }
    }
}
