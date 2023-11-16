package com.catchtable.clone.shop.domain.reserve.interfaces.dto;

import com.catchtable.clone.shop.domain.reserve.domain.ShopReserveMenu;
import com.catchtable.clone.shop.domain.reserve.domain.info.ShopReserveMenuInfo;
import com.catchtable.clone.shop.domain.reserve.domain.command.ShopReserveMenuRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ShopReserveMenuRegisterDto {

    @Getter
    @Setter
    @ToString
    public static class request {
        private String shopToken;
        private ShopReserveMenu.Type type;
        @Size(max = 100, message = "메뉴이름은 최대 100자로 입력해주세요.")
        private String reserveMenu;
        @Size(max = 300, message = "메뉴설명은 최대 300자로 입력해주세요.")
        private String reserveMenuIntro;
        private int reserveMenuPrice;
        private String startAt;
        private String lastAt;

        public ShopReserveMenuRegisterCommand toCommand(String shopToken) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime sTime = LocalTime.parse(startAt, formatter);
            LocalTime lTime = LocalTime.parse(lastAt, formatter);

            return ShopReserveMenuRegisterCommand.builder()
                    .shopToken(shopToken)
                    .type(type)
                    .reserveMenu(reserveMenu)
                    .reserveMenuIntro(reserveMenuIntro)
                    .reserveMenuPrice(reserveMenuPrice)
                    .startAt(sTime)
                    .lastAt(lTime)
                    .build();
        }

    }

    @Getter
    @ToString
    public static class response {
        private final ShopReserveMenu.Type type;
        private final String reserveMenu;
        private final String reserveMenuIntro;
        private final int reserveMenuPrice;
        private final LocalTime startAt;
        private final LocalTime lastAt;

        public response(ShopReserveMenuInfo reserveMenuInfo) {
            this.type = reserveMenuInfo.getType();
            this.reserveMenu = reserveMenuInfo.getReserveMenu();
            this.reserveMenuIntro = reserveMenuInfo.getReserveMenuIntro();
            this.reserveMenuPrice = reserveMenuInfo.getReserveMenuPrice();
            this.startAt = reserveMenuInfo.getStartAt();
            this.lastAt = reserveMenuInfo.getLastAt();
        }
    }
}
