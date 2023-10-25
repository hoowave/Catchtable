package com.catchtable.clone.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_terms")
public class TermsVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public TermsVO(int mno, String peristalsis, String terms_1, String terms_2, String terms_3, String terms_4, String terms_5, String terms_6_1, String terms_6_2, String terms_6_3){
        this.mno = mno;
        this.peristalsis = peristalsis;
        this.terms_1 = terms_1;
        this.terms_2 = terms_2;
        this.terms_3 = terms_3;
        this.terms_4 = terms_4;
        this.terms_5 = terms_5;
        this.terms_6_1 = terms_6_1;
        this.terms_6_2 = terms_6_2;
        this.terms_6_3 = terms_6_3;
    }
}
