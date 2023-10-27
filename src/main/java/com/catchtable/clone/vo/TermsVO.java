package com.catchtable.clone.vo;

import com.catchtable.clone.dto.JoinDTO;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TermsVO {

    private int tno;
    private int mno;
    private String peristalsis;
    private String terms_1;
    private String terms_2;
    private String terms_3;
    private String terms_4;
    private String terms_5;
    private String terms_6_1;
    private String terms_6_2;
    private String terms_6_3;

    public TermsVO(JoinDTO joinDTO, int mno) {
        this.mno = mno;
        if(!termsValidate(joinDTO)){
            throw new IllegalArgumentException("유효하지 않은 값입니다.");
        }
        this.peristalsis = joinDTO.getPeristalsis();
        this.terms_1 = joinDTO.getTerms_1();
        this.terms_2 = joinDTO.getTerms_2();
        this.terms_3 = joinDTO.getTerms_3();
        this.terms_4 = joinDTO.getTerms_4();
        this.terms_5 = joinDTO.getTerms_5();
        this.terms_6_1 = joinDTO.getTerms_6_1();
        this.terms_6_2 = joinDTO.getTerms_6_2();
        this.terms_6_3 = joinDTO.getTerms_6_3();
    }

    private boolean termsValidate(JoinDTO joinDTO) {
        if (joinDTO.getPeristalsis().equals("")
                || joinDTO.getTerms_1().equals("")
                || joinDTO.getTerms_2().equals("")
                || joinDTO.getTerms_3().equals("")
                || joinDTO.getTerms_4().equals("")
                || joinDTO.getTerms_5().equals("")
                || joinDTO.getTerms_6_1().equals("")
                || joinDTO.getTerms_6_2().equals("")
                || joinDTO.getTerms_6_3().equals("")) {
            return false;
        }
        return true;
    }
}
