package com.catchtable.clone.domain.terms;

import lombok.Getter;


@Getter
public class TermsInfo {
    private final String memberToken;
    private final String privacyOfferAgree;
    private final String pushNotify;
    private final String smsNotify;
    private final String emailNotify;

    public TermsInfo(Terms terms){
        this.memberToken = terms.getMemberToken();
        this.privacyOfferAgree = terms.getPrivacyOfferAgree();
        this.pushNotify = terms.getPushNotify();
        this.smsNotify = terms.getSmsNotify();
        this.emailNotify = terms.getEmailNotify();
    }

}
