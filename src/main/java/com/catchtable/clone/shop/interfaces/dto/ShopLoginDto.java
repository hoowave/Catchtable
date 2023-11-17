package com.catchtable.clone.shop.interfaces.dto;

import com.catchtable.clone.shop.domain.Category;
import com.catchtable.clone.shop.domain.info.ShopInfo;
import com.catchtable.clone.shop.domain.command.ShopLoginCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

public class ShopLoginDto {

    @Getter
    @Setter
    @ToString
    public static class LoginRequest {
        @NotEmpty(message = "ID는 필수값입니다.")
        private String shopId;
        @NotEmpty(message = "PW는 필수값입니다.")
        private String shopPw;

        public ShopLoginCommand toCommand() {
            return ShopLoginCommand.builder()
                    .shopId(shopId)
                    .shopPw(shopPw)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class LoginResponse {
        private String shopToken;
        private String shopId;
        private Category category;
        private String shopName;
        private String shopIntroduction;
        private LocalDateTime createdAt;

        public LoginResponse(ShopInfo shopInfo) {
            this.shopToken = shopInfo.getShopToken();
            this.shopId = shopInfo.getShopId();
            this.category = shopInfo.getCategory();
            this.shopName = shopInfo.getShopName();
            this.shopIntroduction = shopInfo.getShopIntroduction();
            this.createdAt = shopInfo.getCreatedAt();
        }
    }
}
