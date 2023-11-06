package com.catchtable.clone.domain.shop;

import com.catchtable.clone.common.util.TokenGenerator;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class Shop {
    private static final String PREFIX_SHOP = "so_";
    // tbl_shop
    private Long id;
    private String shopToken;
    @Size(min = 2, max = 20, message = "ERROR shopId")
    private String shopId;
    @Pattern(regexp = "^(?:(?=.*[A-Za-z])(?=.*[0-9])|(?=.*[A-Za-z])(?=.*[^A-Za-z0-9])|(?=.*[0-9])(?=.*[^A-Za-z0-9])).{8,20}$",
            message = "ERROR Password")
    private String shopPw;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Size(min = 10, max = 15, message = "ERROR shopName")
    private String shopName;
    @Size(max = 200, message = "ERROR shopIntroduction")
    private String shopIntroduction;
    private LocalDateTime createdAt;

    @Builder
    public Shop(String shopId, String shopPw,
                Category category, String shopName, String shopIntroduction) {
        this.shopToken = TokenGenerator.randomCharacterWithPrefix(PREFIX_SHOP);
        this.shopId = shopId;
        this.shopPw = shopPw;
        this.category = category;
        this.shopName = shopName;
        this.shopIntroduction = shopIntroduction;
        this.createdAt = LocalDateTime.now();
    }

    public Shop(String shopId, String shopPw) {
        this.shopId = shopId;
        this.shopPw = shopPw;
    }
}
