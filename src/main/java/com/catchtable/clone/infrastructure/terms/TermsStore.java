package com.catchtable.clone.infrastructure.terms;

import com.catchtable.clone.domain.terms.Terms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermsStore {
    Terms store(Terms initTerms);
}
