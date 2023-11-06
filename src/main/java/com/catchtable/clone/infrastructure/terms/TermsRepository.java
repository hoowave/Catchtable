package com.catchtable.clone.infrastructure.terms;

import com.catchtable.clone.domain.member.Terms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermsRepository {
    Long termsStore(Terms initTerms);
}