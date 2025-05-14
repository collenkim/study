package backend.study.adapterpattern.oauth2.handler;

import backend.study.adapterpattern.security.dto.CustomUserPrincipal;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication) throws IOException {

        CustomUserPrincipal user = (CustomUserPrincipal) authentication.getPrincipal();

        if (user.isNewUser()) {
            // 회원가입 페이지로 리다이렉트 (프론트 주소로)
            String email = (String) user.getAttributes().get("email");
            String name = (String) user.getAttributes().get("name");

            // 예: 프론트에서 /signup 경로로 처리
            String signupUrl = "https://your-frontend.com/signup?email=" + email + "&name=" + name;

            response.setStatus(HttpServletResponse.SC_FOUND);
            response.setHeader("Location", signupUrl);
            return;
        }

        // 기존 회원이면 JWT 발급 등의 처리
        String token = jwtProvider.createToken(user.getName());
        response.setContentType("application/json");
        response.getWriter().write("{\"token\": \"" + token + "\"}");
    }

}
