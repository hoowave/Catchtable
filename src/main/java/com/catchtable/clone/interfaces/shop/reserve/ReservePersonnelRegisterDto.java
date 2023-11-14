package com.catchtable.clone.interfaces.shop.reserve;

import com.catchtable.clone.domain.shop.reserve.personnel.ReservePersonnelInfo;
import com.catchtable.clone.domain.shop.reserve.personnel.register.ReservePersonnelRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReservePersonnelRegisterDto {

    @Getter
    @Setter
    @ToString
    public static class request {
        private String shopToken;
        private String reserveAt;
        private int personnel;

        public ReservePersonnelRegisterCommand toCommand(String shopToken) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime rTime = LocalTime.parse(reserveAt, formatter);
            return ReservePersonnelRegisterCommand.builder()
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

        public response(ReservePersonnelInfo reservePersonnelInfo) {
            this.shopToken = reservePersonnelInfo.getShopToken();
            this.reserveAt = reservePersonnelInfo.getReserveAt();
            this.personnel = reservePersonnelInfo.getPersonnel();
        }
    }
}
