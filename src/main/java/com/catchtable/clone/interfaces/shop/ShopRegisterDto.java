package com.catchtable.clone.interfaces.shop;

import com.catchtable.clone.domain.shop.Category;
import com.catchtable.clone.domain.shop.ShopInfo;
import com.catchtable.clone.domain.shop.register.ShopInformationRegisterCommand;
import com.catchtable.clone.domain.shop.register.ShopRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ShopRegisterDto {
    @Getter
    @Setter
    @ToString
    public static class registerRequest {
        // tbl_shop
        @Size(min = 2, max = 20, message = "아이디는 2~20자로 입력해주세요.")
        private String shopId;
        @Pattern(regexp = "^(?:(?=.*[A-Za-z])(?=.*[0-9])|(?=.*[A-Za-z])(?=.*[^A-Za-z0-9])|(?=.*[0-9])(?=.*[^A-Za-z0-9])).{8,20}$",
                message = "비밀번호는 영문, 숫자, 특수문자 중 2종류 이상을 조합하여 8~20자리로 입력해주세요.")
        private String shopPw;
        private Category category;
        @Size(min = 2, max = 20, message = "가게이름은 2~20자로 입력해주세요.")
        private String shopName;
        @Size(max = 200, message = "가게소개는 최대 200자로 입력해주세요.")
        private String shopIntroduction;

        // tbl_shop_information
        @Size(min = 10, max = 12, message = "가게전화번호는 10~12자로 입력해주세요.")
        private String phone;
        @Size(max = 300, message = "매장소개는 최대 300자로 입력해주세요.")
        private String infoIntroduction;
        @Size(max = 300, message = "영업시간은 최대 300자로 입력해주세요.")
        private String opening;
        @Size(max = 300, message = "정기휴무는 최대 300자로 입력해주세요.")
        private String holiday;
        @Size(max = 300, message = "안내 및 유의사항은 최대 300자로 입력해주세요.")
        private String instruction;
        @Size(max = 300, message = "홈페이지는 최대 300자로 입력해주세요.")
        private String homepage;

        public ShopRegisterCommand toShopCommand() {
            return ShopRegisterCommand.builder()
                    .shopId(shopId)
                    .shopPw(shopPw)
                    .category(category)
                    .shopName(shopName)
                    .shopIntroduction(shopIntroduction)
                    .build();
        }

        public ShopInformationRegisterCommand toShopInformationCommand() {
            return ShopInformationRegisterCommand.builder()
                    .phone(phone)
                    .infoIntroduction(infoIntroduction)
                    .opening(opening)
                    .holiday(holiday)
                    .instruction(instruction)
                    .homepage(homepage)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        private final String shopName;

        public RegisterResponse(ShopInfo shopInfo) {
            this.shopName = shopInfo.getShopName();
        }
    }
}
