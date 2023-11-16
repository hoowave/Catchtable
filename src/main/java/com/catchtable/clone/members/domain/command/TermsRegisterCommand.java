package com.catchtable.clone.members.domain.command;

import com.catchtable.clone.members.domain.Terms;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class TermsRegisterCommand {
    private String memberToken;
    private String peristalsis;
    private String privacyOfferAgree;
    private String pushNotify;
    private String smsNotify;
    private String emailNotify;

    public Terms toEntity(String memberToken) {
        return Terms.builder()
                .memberToken(memberToken)
                .peristalsis(peristalsis)
                .privacyOfferAgree(privacyOfferAgree)
                .pushNotify(pushNotify)
                .smsNotify(smsNotify)
                .emailNotify(emailNotify)
                .build();
    }
}
