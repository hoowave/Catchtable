package com.catchtable.clone.members.infrastructure;

import com.catchtable.clone.members.domain.Terms;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermsDao {
    Long termsStore(Terms initTerms);
}