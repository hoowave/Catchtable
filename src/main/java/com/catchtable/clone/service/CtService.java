package com.catchtable.clone.service;

import com.catchtable.clone.repository.TermsRepository;
import com.catchtable.clone.repository.UserRepository;
import com.catchtable.clone.userdto.JoinDTO;
import com.catchtable.clone.vo.TermsVO;
import com.catchtable.clone.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CtService {

    private UserRepository userRepository;
    private TermsRepository termsRepository;

    public CtService(UserRepository userRepository, TermsRepository termsRepository) {
        this.userRepository = userRepository;
        this.termsRepository = termsRepository;
    }

    public boolean join(JoinDTO joinDTO) {
        // 서버측 유효성 검사 - 1차적으로 빈 값만 체크
        if (joinDTO.getName().equals("")
                || joinDTO.getPhone().equals("")
                || joinDTO.getPassword().equals("")
                // || joinDTO.getNickname().equals("") 닉네임 제외
                || joinDTO.getPeristalsis().equals("")
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

        // 유효성 검사가 끝난 뒤, 생성자를 통해 VO 생성 후 DB에 값 저장
        // 더 구체적인 유효성 검사와 비밀번호 암호화 작업 필요

        UserVO userVO = new UserVO(joinDTO.getName(), joinDTO.getPhone(), joinDTO.getPassword(), joinDTO.getNickname(), joinDTO.getDate());
        int mno = userRepository.save(userVO).getMno();

        // 왜래키인 insertID 값을 TermsVO의 mno에 입력

        TermsVO termsVO = new TermsVO(mno, joinDTO.getPeristalsis(), joinDTO.getTerms_1(), joinDTO.getTerms_2(), joinDTO.getTerms_3(), joinDTO.getTerms_4(), joinDTO.getTerms_5(), joinDTO.getTerms_6_1(), joinDTO.getTerms_6_2(), joinDTO.getTerms_6_3());
        termsRepository.save(termsVO);
        return true;
    }

    public boolean nicknameCheck(JoinDTO joinDTO) {
        Optional<UserVO> userVO = userRepository.findByNickname(joinDTO.getNickname());
        if (!userVO.isEmpty()) {
            return false;
        }
        return true;
    }

    public UserVO login(JoinDTO joinDTO) {
        Optional<UserVO> userVO = userRepository.login(joinDTO.getNickname(), joinDTO.getPassword());
        if(userVO.isEmpty()){
            return null;
        }
        return userVO.get();
    }
}