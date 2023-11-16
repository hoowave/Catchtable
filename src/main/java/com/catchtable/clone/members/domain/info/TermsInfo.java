package com.catchtable.clone.members.domain.info;

import com.catchtable.clone.members.domain.Terms;
import lombok.Getter;


@Getter
public class TermsInfo {
    private final String memberToken;
    private final String peristalsis;
    private final String pushNotify;
    private final String smsNotify;
    private final String emailNotify;

    public TermsInfo(Terms terms) {
        this.memberToken = terms.getMemberToken();
        this.peristalsis = terms.getPeristalsis();
        this.pushNotify = terms.getPushNotify();
        this.smsNotify = terms.getSmsNotify();
        this.emailNotify = terms.getEmailNotify();
    }

}
