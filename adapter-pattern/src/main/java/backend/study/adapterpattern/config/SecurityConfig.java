package backend.study.adapterpattern.config;

import backend.study.adapterpattern.auth.filter.BasicLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final BasicLoginFilter loginFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable) // REST API에서는 보통 CSRF 미사용
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/api/v1/auth/**", "/api/v1/auth/oauth2/**").permitAll()
                .anyRequest().authenticated())
            .addFilterBefore(loginFilter, UsernamePasswordAuthenticationFilter.class)
            .oauth2Login(oauth -> oauth
                .authorizationEndpoint(authorize -> authorize.baseUri("/oauth2/authorization"))
                .redirectionEndpoint(redirect -> redirect.baseUri("/oauth2/callback/*"))
                .userInfoEndpoint(userInfo -> userInfo.userService())
                .successHandler(oAuth2SuccessHandler())
                .failureHandler(oAuth2FailureHandler())
            )
            .formLogin(AbstractHttpConfigurer::disable);

        return http.build();
    }
}
