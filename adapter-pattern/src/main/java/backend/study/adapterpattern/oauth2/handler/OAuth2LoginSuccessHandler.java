package backend.study.adapterpattern.oauth2.handler;

import backend.study.adapterpattern.user.repository.UserIdpRepository;
import backend.study.adapterpattern.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@RequiredArgsConstructor
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final UserIdpRepository userIdpRepository;

    /**
     * OAuth2 로그인 성공 시 호출되는 핸들러
     * <p>
     * 1. 신규 회원 가입 시 회원가입 페이지로 리다이렉트 2. 기존 회원이면 JWT 발급
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain,
            authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {

    }
        /*HttpServletResponse response,
        Authentication authentication) throws IOException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String registrationId = ((OAuth2AuthenticationToken) authentication).getAuthorizedClientRegistrationId();
        String providerId = (String) oAuth2User.getAttributes().get("sub");

        ProviderCd provider = ProviderCd.getByProvider(registrationId);

        Optional<UserIdpEntity> userOptional = userIdpRepository
            .findByProviderAndProviderId(provider, providerId)
            .map(userIdp -> userIdp.getUser()); // userIdp → User 관계 가정

        if (userOptional.isEmpty()) {
            // 신규 사용자 → 수신 동의 페이지로
            String redirectUrl = String.format("/signup/consent?provider=%s&providerId=%s",
                registrationId, providerId);
            response.sendRedirect(redirectUrl);
            return;
        }

        // 기존 사용자 → JWT 발급 및 리다이렉트
        UserIdpEntity user = userOptional.get();
        String token = jwtUtil.generateToken(user.getEmail()); // 혹은 user.getId(), getUsername 등

        // 토큰을 쿠키로 설정 (or 리디렉트 URL에 포함)
        Cookie jwtCookie = new Cookie("token", token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setPath("/");
        jwtCookie.setMaxAge(3600); // 1시간 유효
        response.addCookie(jwtCookie);

        response.sendRedirect("/"); // 로그인 후 이동할 페이지*/

}
