package backend.study.webclient.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AreaCd {

    AREA_105(105, "강릉", "강원도"),
    AREA_108(108, "서울", "전국"),
    AREA_109(109, "서울", "서울,인천,경기도"),
    AREA_131(131, "청주", "충청북도"),
    AREA_133(133, "대전", "대전,세종,충청남도"),
    AREA_143(143, "대구", "대구,경상북도"),
    AREA_146(146, "전주", "전북자치도"),
    AREA_156(156, "광주", "광주,전라남도"),
    AREA_159(159, "부산", "부산,울산,경상남도"),
    AREA_184(184, "제주", "제주도"),
    ;

    private final Integer code;
    private final String name;
    private final String area;
}
