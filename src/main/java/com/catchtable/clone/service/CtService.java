package com.catchtable.clone.service;

import com.catchtable.clone.dao.CtDao;
import com.catchtable.clone.dto.JoinDTO;
import com.catchtable.clone.vo.TermsVO;
import com.catchtable.clone.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CtService {

    private CtDao ctDao;

    public CtService(CtDao ctDao) {
        this.ctDao = ctDao;
    }

    public boolean join(JoinDTO joinDTO) {
        // 유효성 검사는 VO로 이동 시킴!!(객체 생성과 동시에 검사)
        // 여기선 Service <-> DB 간의 처리에 대한 것을 다룸(?)
        // Validation도 사용해보기..!!
        UserVO userVO = new UserVO(joinDTO);
        if (!ctDao.joinUser(userVO)) {
            // 여기는 에러에 대한 로그를 남기는게 바람직할까?
            throw new IllegalArgumentException("회원정보 처리 오류!!");
        }
        TermsVO termsVO = new TermsVO(joinDTO, userVO.getMno());
        if (!ctDao.joinTerms(termsVO)) {
            // 여기도 에러에 대한 로그를 남기는게 바람직할까?
            throw new IllegalArgumentException("약관 처리 오류!!");
        }
        return true;
    }

    public boolean nicknameCheck(JoinDTO joinDTO) {
        Optional<JoinDTO> rsJoinDTO = ctDao.nicknameCheck(joinDTO.getNickname());
        if (!rsJoinDTO.isEmpty()) {
            //exception을 남길 필요는 없어 보임
            return false;
        }
        return true;
    }

    public UserVO login(JoinDTO joinDTO) {
        Optional<JoinDTO> rsJoinDTO = ctDao.loginUser(joinDTO.getPhone(), joinDTO.getNickname(), joinDTO.getPassword());
        if(rsJoinDTO.isEmpty()){
            return null;
        }
        return new UserVO(rsJoinDTO.get());
    }
}

// ---------------JPA(이전)---------------
// 유효성 검사가 끝난 뒤, 생성자를 통해 VO 생성 후 DB에 값 저장
// 더 구체적인 유효성 검사와 비밀번호 암호화 작업 필요

// UserVO userVO = new UserVO(joinDTO.getName(), joinDTO.getPhone(), joinDTO.getPassword(), joinDTO.getNickname(), joinDTO.getDate());
// int mno = userRepository.save(userVO).getMno();

// 왜래키인 insertID 값을 TermsVO의 mno에 입력

// TermsVO termsVO = new TermsVO(mno, joinDTO.getPeristalsis(), joinDTO.getTerms_1(), joinDTO.getTerms_2(), joinDTO.getTerms_3(), joinDTO.getTerms_4(), joinDTO.getTerms_5(), joinDTO.getTerms_6_1(), joinDTO.getTerms_6_2(), joinDTO.getTerms_6_3());
// termsRepository.save(termsVO);