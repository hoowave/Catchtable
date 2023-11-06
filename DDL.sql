CREATE TABLE `tbl_members` (
                               `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
                               `member_token` varchar(30) NOT NULL comment '식별자',
                               `name` varchar(10) NOT NULL comment '이름',
                               `phone` varchar(15) NOT NULL comment '전화번호',
                               `password` varchar(100) NOT NULL comment '비밀번호',
                               `nickname` varchar(20) comment '닉네임',
                               `status` varchar(8) NOT NULL comment '계정상태',
                               `created_at` datetime(6) not null comment '생성 일시',
                               `updated_at` datetime(6) null comment '수정 일시',
                               PRIMARY KEY (`id`)
) comment '회원정보 테이블' charset = utf8mb4;

CREATE TABLE `tbl_terms` (
                             `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
                             `member_token` varchar(30) NOT NULL comment '식별자',
                             `peristalsis` varchar(1) NOT NULL comment '예약 앱에 연동하기',
                             `privacy_offer_agree` varchar(1) NOT NULL comment '개인정보 제공 동의',
                             `push_notify` varchar(1) NOT NULL comment '푸시 알림',
                             `sms_notify` varchar(1) NOT NULL comment 'SMS 수신',
                             `email_notify` varchar(1) NOT NULL comment '이메일 수신',
                             PRIMARY KEY (`id`)
) comment '약관 테이블' charset = utf8mb4;

CREATE TABLE `tbl_shop` (
                            `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
                            `shop_token` varchar(30) NOT NULL comment '식별자',
                            `shop_id` varchar(20) NOT NULL comment '사장님 아이디',
                            `shop_pw` varchar(100) NOT NULL comment '사장님 비밀번호',
                            `category` varchar(20) NOT NULL comment '카테고리',
                            `name` varchar(20) NOT NULL comment '가게이름',
                            `introduction` varchar(200) comment '가게소개',
                            `created_at` datetime(6) not null comment '생성 일시',
                            PRIMARY KEY (`id`)
) comment '가게정보 테이블' charset = utf8mb4;

CREATE TABLE `tbl_shop_information` (
                                        `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
                                        `shop_token` varchar(30) NOT NULL comment '식별자',
                                        `phone` varchar(15) comment'가게 전화번호',
                                        `info_introduction` varchar(300) comment '매장소개',
                                        `opening` varchar(300) comment '영업시간',
                                        `holiday` varchar(300) comment '정기휴무',
                                        `instruction` varchar(300) comment '안내 및 유의사항',
                                        `homepage` varchar(300) comment '홈페이지',
                                        PRIMARY KEY (`id`)
) comment '가게 상세정보 테이블' charset = utf8mb4;
