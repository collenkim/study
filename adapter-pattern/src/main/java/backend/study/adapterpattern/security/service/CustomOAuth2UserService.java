package backend.study.adapterpattern.security.service;

import static backend.study.adapterpattern.login.cd.ProviderCd.getEmail;
import static backend.study.adapterpattern.login.cd.ProviderCd.getUsername;

import backend.study.adapterpattern.error.exception.OAuth2UserNotRegisteredException;
import backend.study.adapterpattern.login.cd.ProviderCd;
import backend.study.adapterpattern.security.dto.CustomUserPrincipal;
import backend.study.adapterpattern.user.domain.UserAccountIdpEntity;
import backend.study.adapterpattern.user.repository.UserIdpRepository;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserIdpRepository userIdpRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 클라이언트 정보
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // OAuth2 제공자에서 사용자의 고유 식별자 필드 이름
        String userNameAttributeName = userRequest.getClientRegistration()
            .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        // 사용자 정보 Map
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 사용자 정보를 기반으로 회원 PK 조회
        String providerId = attributes.get(userNameAttributeName).toString();

        // DB 조회
        Optional<UserAccountIdpEntity> userIdp =
            userIdpRepository.findByProviderAndProviderId(ProviderCd.getByProvider(registrationId),
                providerId);

        if (userIdp.isEmpty()) {
            throw new OAuth2UserNotRegisteredException("소셜 가입 정보가 존재하지 않음.");
        }

        String email = getEmail(registrationId, attributes);

        String username = getUsername(registrationId, attributes);

        log.info("소셜 로그인: provider={}, providerId={}", registrationId, providerId);

        // 최종적으로 반환할 OAuth2User (CustomOAuth2User도 가능)
        return new CustomUserPrincipal(providerId, username, email,
            null, true, attributes);
    }


}
