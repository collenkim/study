package backend.study.adapterpattern.auth.filter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Slf4j
@RequiredArgsConstructor
public class BasicLoginFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
        HttpServletResponse response) {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        log.info("username: {}, password: {}", username, password);

        // Perform authentication logic here
        // For example, you can use the authenticationManager to authenticate the user

        return super.attemptAuthentication(request, response); // Return the authentication result
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
        HttpServletResponse response, Authentication authResult) {
        super.successfulAuthentication(request, response, authResult);
        log.info("Authentication successful for user: {}", authResult.getName());
    }

}
