package com.catchtable.clone.interfaces.member;

import com.catchtable.clone.domain.member.register.MemberRegisterCommand;
import com.catchtable.clone.domain.member.MemberInfo;
import com.catchtable.clone.domain.member.register.TermsRegisterCommand;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MemberRegisterDto {
    // static inner class 사용해보자

    @Getter
    @Setter
    @ToString
    public static class RegisterRequest {
        @Size(min = 2, max = 5, message = "이름은 2~5자로 입력해주세요.")
        private String name;
        @Size(min = 10, max = 12, message = "휴대폰 번호는 10~12자로 입력해주세요.")
        private String phone;
        @Pattern(regexp = "^(?:(?=.*[A-Za-z])(?=.*[0-9])|(?=.*[A-Za-z])(?=.*[^A-Za-z0-9])|(?=.*[0-9])(?=.*[^A-Za-z0-9])).{8,20}$",
                message = "비밀번호는 영문, 숫자, 특수문자 중 2종류 이상을 조합하여 8~20자리로 입력해주세요.")
        private String password;
        @Size(max = 10, message = "닉네임은 최대 10자로 입력해주세요.")
        private String nickname;

        @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
        private String peristalsis;
        @Pattern(regexp = "^Y$", message = "만 14세 이상 동의가 필요합니다.")
        private String useAgree;
        @Pattern(regexp = "^Y$", message = "캐치테이블 이용 약관에 동의가 필요합니다.")
        private String privacyAgree;
        @Pattern(regexp = "^Y$", message = "개인정보 수집 및 이용 약관에 동의가 필요합니다.")
        private String providedAgree;
        @Pattern(regexp = "^Y$", message = "개인정보 제3자 제공에 동의가 필요합니다.")
        private String privacyThirdOfferAgree;
        @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
        private String privacyOfferAgree;
        @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
        private String pushNotify;
        @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
        private String smsNotify;
        @Pattern(regexp = "^[YN]$", message = "허용되지 않은 값입니다.")
        private String emailNotify;

        public MemberRegisterCommand toMemberCommand() {
            return MemberRegisterCommand.builder()
                    .name(name)
                    .phone(phone)
                    .password(password)
                    .nickname(nickname)
                    .build();
        }

        public TermsRegisterCommand toTermsCommand() {
            return TermsRegisterCommand.builder()
                    .peristalsis(peristalsis)
                    .privacyOfferAgree(privacyOfferAgree)
                    .pushNotify(pushNotify)
                    .smsNotify(smsNotify)
                    .emailNotify(emailNotify)
                    .build();
        }
    }

    @Getter
    @ToString
    public static class RegisterResponse {
        //회원가입 후 이름만 반환
        //ex) name 님 환영합니다.
        private final String name;

        public RegisterResponse(MemberInfo memberInfo) {
            this.name = memberInfo.getName();
        }
    }
}
