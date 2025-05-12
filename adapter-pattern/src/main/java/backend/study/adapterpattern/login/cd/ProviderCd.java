package backend.study.adapterpattern.login.cd;

import backend.study.adapterpattern.error.exception.UnsupportedProviderException;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProviderCd {

    GOOGLE("google", "구글"),
    APPLE("apple", "애플"),
    NAVER("naver", "네이버"),
    KAKAO("kakao", "카카오"),
    ;

    private final String provider;
    private final String providerName;

    public static void isValidProvider(String provider) {
        for (ProviderCd providerCd : ProviderCd.values()) {
            if (providerCd.getProvider().equals(provider.toLowerCase())) {
                return;
            }
        }
        throw new UnsupportedProviderException("지원하지 않는 소셜 로그인 제공자입니다: " + provider);
    }

}
