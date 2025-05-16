package backend.study.adapterpattern.login.cd;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoginType {

    BASIC("basic", "일반 로그인"),
    OAUTH2("oauth2", "소셜 로그인"),
    ;

    private final String code;
    private final String name;

}
