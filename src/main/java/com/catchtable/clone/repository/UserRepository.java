package com.catchtable.clone.repository;

import com.catchtable.clone.vo.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserVO, Integer> {
    // 회원에 관한 리포지토리
    Optional<UserVO> findByNickname(String Nickname);

    // 아직 JPA에 깊이있게 이해하지 못해서 네이티브 쿼리로..
    @Query(value = "SELECT * FROM tbl_user WHERE password = :pw AND phone = :id OR nickname = :id", nativeQuery = true)
    Optional<UserVO> login(String id, String pw);
}
