package com.catchtable.clone.shop.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    NULL("없음"),
    COURSE("코스요리"),
    PASTA("파스타"),
    ITALIAN("이탈리아음식"),
    DINING("다이닝바"),
    SUSHI("스시,초밥"),
    SASHIMI("회,사시미"),
    KOREAN("한식"),
    BEER("맥주,호프"),
    JAPANESE("일식"),
    SUSHIOMAKASE("스시오마카세"),
    VEGETARIAN("베지테리안/비건"),
    CHINESE("중식"),
    IZAKAYA("이자카야"),
    BUFFET("뷔페"),
    CAFE("카페,디저트"),
    BEEF("소고기구이"),
    BEEFOMAKASE("한우오마카세"),
    BRUNCH("브런치"),
    SHABU("샤브샤브"),
    WINE("와인");
    private final String description;

    public String getCategory() {
        return description;
    }
}
