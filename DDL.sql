CREATE TABLE `members` (
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

CREATE TABLE `terms` (
  `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
  `member_token` varchar(30) NOT NULL comment '식별자',
  `peristalsis` varchar(1) NOT NULL comment '예약 앱에 연동하기',
  `privacy_offer_agree` varchar(1) NOT NULL comment '개인정보 제공 동의',
  `push_notify` varchar(1) NOT NULL comment '푸시 알림',
  `sms_notify` varchar(1) NOT NULL comment 'SMS 수신',
  `email_notify` varchar(1) NOT NULL comment '이메일 수신',
  PRIMARY KEY (`id`)
) comment '약관 테이블' charset = utf8mb4;

CREATE TABLE `shop` (
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

CREATE TABLE `shop_information` (
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

CREATE TABLE `shop_reserve_menu` (
  `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
  `shop_token` varchar(30) NOT NULL comment '식별자',
  `type` varchar(6) NOT NULL comment '메뉴구분',
  `menu_name` varchar(100) NOT NULL comment '메뉴이름',
  `menu_intro` varchar(300) NOT NULL comment '메뉴설명',
  `menu_price` int NOT NULL comment '메뉴가',
  `start_at` time NOT NULL comment '예약가능시작일시',
  `last_at` time NOT NULL comment '예약가능마감일시',
  PRIMARY KEY (`id`)
) comment '예약 메뉴설정 테이블' charset = utf8mb4;

CREATE TABLE `shop_reserve_personnel` (
  `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
  `shop_token` varchar(30) NOT NULL comment '식별자',
  `reserve_at` time NOT NULL comment '예약시간',
  `personnel` INT NOT NULL comment '예약가능인원',
  PRIMARY KEY (`id`)
) comment '예약시간, 인원설정 테이블' charset = utf8mb4;

CREATE TABLE `reserve` (
  `id` bigint NOT NULL AUTO_INCREMENT comment '관리번호',
  `member_token` varchar(30) NOT NULL comment '회원 식별자',
  `shop_token` varchar(30) NOT NULL comment '상점 식별자',
  `reserve_at` datetime(6) NOT NULL comment '예약 일시',
  `personnel` int NOT NULL comment '예약 인원',
  `reserve_menu` bigint NOT NULL comment '예약 메뉴',
  `visit` varchar(1) NOT NULL comment '방문 여부',
  `message` varchar(300) NOT NULL comment '요청사항',
  PRIMARY KEY (`id`)
) comment '예약정보 테이블' charset = utf8mb4;

-- 회원별 예약정보
SELECT
(SELECT name FROM shop WHERE shop_token = a.shop_token ) as shop_name,
a.reserve_at,
a.personnel,
a.visit,
a.message,
(SELECT menu_name FROM shop_reserve_menu WHERE shop_token = a.shop_token) as menu_name,
(SELECT (menu_price*a.personnel) FROM shop_reserve_menu WHERE shop_token = a.shop_token) as menu_price
FROM reserve a
WHERE member_token = "mb_YrlhVBqG4LDSHPkiQ"

-- 상점별 예약정보
SELECT
(SELECT name FROM members WHERE member_token  = a.member_token ) as member_name,
a.reserve_at,
a.personnel,
a.visit,
a.message,
(SELECT menu_name FROM shop_reserve_menu WHERE shop_token = a.shop_token) as menu_name,
(SELECT (menu_price*a.personnel) FROM shop_reserve_menu WHERE shop_token = a.shop_token) as menu_price
FROM reserve a
WHERE shop_token = "so_mLvPgAuHJY4rdqtWa"
ORDER BY reserve_at ASC