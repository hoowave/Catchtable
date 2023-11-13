package com.catchtable.clone.domain.member;

import com.catchtable.clone.domain.member.login.MemberLoginCommand;
import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.register.TermsRegisterCommand;
import com.catchtable.clone.domain.member.reserve.ReserveCommand;
import com.catchtable.clone.domain.member.reserve.ReserveInfo;
import com.catchtable.clone.infrastructure.member.MemberRepository;
import com.catchtable.clone.infrastructure.terms.TermsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final TermsRepository termsRepository;

    @Override
    public List<MemberReserveInfo> reserveInfoList(String memberToken) {
        List<MemberReserveInfo> reserveInfolist = memberRepository.reserveInfoList(memberToken);
        return reserveInfolist;
    }

    @Override
    @Transactional
    public ReserveInfo reserve(ReserveCommand reserveCommand) {
        Optional<String> shopToken = memberRepository.getShopIdToShopToken(reserveCommand.getShopId());
        if (shopToken.isEmpty()) {
            // 가게ID의 토큰이 존재하지 않을 경우
            return new ReserveInfo(-1);
        }
        int availablePersonnel = memberRepository.getAvailablePersonnel(reserveCommand.getReserveAt(),shopToken.get());
        if(availablePersonnel < reserveCommand.getPersonnel()){
            // 가게 기준 현재 예약 인원보다 예약하려는 인원이 많은지 체크
            return new ReserveInfo(-2);
        }
        var initReserve = reserveCommand.toEntity(shopToken.get());
        memberRepository.reserveStore(initReserve);
        return new ReserveInfo(initReserve);
    }

    @Override
    @Transactional
    public MemberInfo registerMember(MemberRegisterCommand memberRegisterCommand,
                                     TermsRegisterCommand termsRegisterCommand) {
        var initMember = memberRegisterCommand.toEntity();
        memberRepository.memberStore(initMember);
        var initTerms = termsRegisterCommand.toEntity(initMember.getMemberToken());
        termsRepository.termsStore(initTerms);
        // 회원 객체와 약관 객체를 각 각 저장
        return new MemberInfo(initMember);
    }

    @Override
    @Transactional
    public MemberInfo loginMember(MemberLoginCommand memberLoginCommand) {
        var initMember = memberLoginCommand.toEntity();
        Optional<Member> member = memberRepository.login(initMember);

        if (!member.isEmpty()) {
            return new MemberInfo(member.get());
        } else {
            //로그인 실패 시 빈 객체 반환
            return new MemberInfo();
        }

    }
}
