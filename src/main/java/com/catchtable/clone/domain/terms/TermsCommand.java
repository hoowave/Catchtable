package com.catchtable.clone.domain.terms;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TermsCommand {
    private final String memberToken;
    private final String privacyOfferAgree;
    private final String pushNotify;
    private final String smsNotify;
    private final String emailNotify;

    public Terms toEntity(){
        return Terms.builder()
                .memberToken(memberToken)
                .privacyOfferAgree(privacyOfferAgree)
                .pushNotify(pushNotify)
                .smsNotify(smsNotify)
                .emailNotify(emailNotify)
                .build();
    }
}
