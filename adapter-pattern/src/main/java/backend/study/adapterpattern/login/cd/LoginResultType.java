package backend.study.adapterpattern.login.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginResultType {

    SUCCESS("success", "로그인 성공"),
    FAIL("fail", "로그인 실패"),
    ;

    private final String code;
    private final String name;

}
