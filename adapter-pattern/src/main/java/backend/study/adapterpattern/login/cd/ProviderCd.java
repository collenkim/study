package backend.study.adapterpattern.login.cd;

import backend.study.adapterpattern.error.exception.UnsupportedProviderException;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;

@Getter
@AllArgsConstructor
public enum ProviderCd {

    GOOGLE("google", "구글"),
    APPLE("apple", "애플"),
    NAVER("naver", "네이버"),
    KAKAO("kakao", "카카오"),
    BASIC("basic", "기본"),
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

    public static ProviderCd getByProvider(String provider) {
        for (ProviderCd providerCd : ProviderCd.values()) {
            if (providerCd.getProvider().equals(provider.toLowerCase())) {
                return providerCd;
            }
        }
        throw new UnsupportedProviderException("지원하지 않는 소셜 로그인 제공자입니다: " + provider);
    }

    public static String getEmail(String registrationId, Map<String, Object> attributes) {
        switch (registrationId) {
            case "google" -> {
                return (String) attributes.get("email");
            }
            case "naver" -> {
                Map<String, Object> response = (Map<String, Object>) attributes.get("response");
                return (String) response.get("email");
            }
            case "kakao" -> {
                Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get(
                    "kakao_account");
                return (String) kakaoAccount.get("email");
            }
            default ->
                throw new OAuth2AuthenticationException("Unsupported provider: " + registrationId);
        }
    }

    public static String getUsername(String registrationId, Map<String, Object> attributes) {
        switch (registrationId) {
            case "google":
                return (String) attributes.get("name");
            case "naver":
                Map<String, Object> response = (Map<String, Object>) attributes.get("response");
                return (String) response.get("name");
            case "kakao":
                Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get(
                    "kakao_account");
                Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
                return (String) profile.get("nickname");
            default:
                throw new OAuth2AuthenticationException("Unsupported provider: " + registrationId);
        }
    }

}
