package com.catchtable.clone.interfaces.shop.reserve;

import com.catchtable.clone.domain.shop.reserve.menu.ReserveMenu;
import com.catchtable.clone.domain.shop.reserve.menu.ReserveMenuInfo;
import com.catchtable.clone.domain.shop.reserve.menu.register.ReserveMenuRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReserveMenuRegisterDto {

    @Getter
    @Setter
    @ToString
    public static class request {
        private String shopToken;
        private ReserveMenu.Type type;
        @Size(max = 100, message = "메뉴이름은 최대 100자로 입력해주세요.")
        private String reserveMenu;
        @Size(max = 300, message = "메뉴설명은 최대 300자로 입력해주세요.")
        private String reserveMenuIntro;
        private int reserveMenuPrice;
        private String startAt;
        private String lastAt;

        public ReserveMenuRegisterCommand toCommand(String shopToken) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime sTime = LocalTime.parse(startAt, formatter);
            LocalTime lTime = LocalTime.parse(lastAt, formatter);

            return ReserveMenuRegisterCommand.builder()
                    .shopToken(shopToken)
                    .type(type)
                    .reserveMenu(reserveMenu)
                    .reserveMenuIntro(reserveMenuIntro)
                    .reserveMenuPrice(reserveMenuPrice)
                    .startAt(Time.valueOf(sTime))
                    .lastAt(Time.valueOf(lTime))
                    .build();
        }

    }

    @Getter
    @ToString
    public static class response {
        private final ReserveMenu.Type type;
        private final String reserveMenu;
        private final String reserveMenuIntro;
        private final int reserveMenuPrice;
        private final Time startAt;
        private final Time lastAt;

        public response(ReserveMenuInfo reserveMenuInfo) {
            this.type = reserveMenuInfo.getType();
            this.reserveMenu = reserveMenuInfo.getReserveMenu();
            this.reserveMenuIntro = reserveMenuInfo.getReserveMenuIntro();
            this.reserveMenuPrice = reserveMenuInfo.getReserveMenuPrice();
            this.startAt = reserveMenuInfo.getStartAt();
            this.lastAt = reserveMenuInfo.getLastAt();
        }
    }
}
