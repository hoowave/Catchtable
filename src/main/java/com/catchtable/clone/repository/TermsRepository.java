package com.catchtable.clone.repository;

import com.catchtable.clone.vo.TermsVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermsRepository extends JpaRepository<TermsVO, Integer> {
    // 약관에 관한 리포지토리
}
