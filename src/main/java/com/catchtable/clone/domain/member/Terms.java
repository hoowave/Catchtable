package com.catchtable.clone.domain.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.Pattern;

@Slf4j
@Getter
@NoArgsConstructor
@ToString
public class Terms {
    private Long id;
    private String memberToken;
    @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
    private String peristalsis;
    @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
    private String privacyOfferAgree;
    @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
    private String pushNotify;
    @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
    private String smsNotify;
    @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
    private String emailNotify;

    @Builder
    public Terms(
            String memberToken,
            String peristalsis,
            String privacyOfferAgree,
            String pushNotify,
            String smsNotify,
            String emailNotify) {
        this.memberToken = memberToken;
        this.peristalsis = peristalsis;
        this.privacyOfferAgree = privacyOfferAgree;
        this.pushNotify = pushNotify;
        this.smsNotify = smsNotify;
        this.emailNotify = emailNotify;
    }
}
