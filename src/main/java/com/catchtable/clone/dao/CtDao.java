package com.catchtable.clone.dao;

import com.catchtable.clone.dto.JoinDTO;
import com.catchtable.clone.vo.TermsVO;
import com.catchtable.clone.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CtDao {
    public boolean joinUser(UserVO userVO);
    public boolean joinTerms(TermsVO termsVO);
    public Optional<JoinDTO> nicknameCheck(String nickname);
    public Optional<JoinDTO> loginUser(String phone, String nickname, String password);
}
