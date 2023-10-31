package com.catchtable.clone.domain.terms;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Getter
@NoArgsConstructor
public class Terms {
    private Long id;
    private String memberToken;
    private String peristalsis;
    private String useAgree;
    private String privacyAgree;
    private String providedAgree;
    private String privacyOfferAgree;
    private String pushNotify;
    private String smsNotify;
    private String emailNotify;

    @Builder
    public Terms(
            String memberToken,
            String peristalsis,
            String useAgree,
            String privacyAgree,
            String providedAgree,
            String privacyOfferAgree,
            String pushNotify,
            String smsNotify,
            String emailNotify) {
        // -- //
        // 여기는 필수동의 구간 DB에 저장할 필요는 없다고 판단, 유효성 검사만 진행
        if (StringUtils.isEmpty(peristalsis)) System.out.println("empty peristalsis");
        if (StringUtils.isEmpty(useAgree)) System.out.println("empty useAgree");
        if (StringUtils.isEmpty(privacyAgree)) System.out.println("empty privacyAgree");
        if (StringUtils.isEmpty(providedAgree)) System.out.println("empty providedAgree");
        // -- //
        if (StringUtils.isEmpty(privacyOfferAgree)) System.out.println("empty privacyOfferAgree");
        if (StringUtils.isEmpty(pushNotify)) System.out.println("empty pushNotify");
        if (StringUtils.isEmpty(smsNotify)) System.out.println("empty smsNotify");
        if (StringUtils.isEmpty(emailNotify)) System.out.println("empty emailNotify");

        this.memberToken = memberToken;
        this.peristalsis = peristalsis;
        this.useAgree = useAgree;
        this.privacyAgree = privacyAgree;
        this.providedAgree = providedAgree;
        this.privacyOfferAgree = privacyOfferAgree;
        this.pushNotify = pushNotify;
        this.smsNotify = smsNotify;
        this.emailNotify = emailNotify;
    }
}
