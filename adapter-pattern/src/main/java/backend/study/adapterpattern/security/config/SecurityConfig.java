package backend.study.adapterpattern.security.config;

import backend.study.adapterpattern.security.filter.JwtAuthenticationFilter;
import backend.study.adapterpattern.security.service.CustomUserDetailsService;
import backend.study.adapterpattern.user.repository.UserRepository;
import backend.study.adapterpattern.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    /**
     * SecurityFilterChain을 Bean으로 등록
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        JwtAuthenticationFilter jwtFilter = new JwtAuthenticationFilter(jwtUtil, userRepository);

        http
            .csrf(AbstractHttpConfigurer::disable) // REST API에서는 보통 CSRF 미사용
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth ->
                auth
                    .requestMatchers("/", "/api/v1/auth/**").permitAll()
                    .anyRequest().authenticated())
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            /*.oauth2Login(oauth ->
                oauth
                    .authorizationEndpoint(authorize -> authorize.baseUri("/oauth2/authorization"))
                    .redirectionEndpoint(redirect -> redirect.baseUri("/oauth2/callback/*"))
                    .userInfoEndpoint(userInfo ->
                        userInfo.userService())
                    .successHandler(oAuth2SuccessHandler())
                    .failureHandler(oAuth2FailureHandler())
            )*/
            .formLogin(AbstractHttpConfigurer::disable);

        return http.build();
    }

    /**
     * PasswordEncoder를 Bean으로 등록
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * AuthenticationManager를 Bean으로 등록
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder managerBuilder =
            http.getSharedObject(AuthenticationManagerBuilder.class);

        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return managerBuilder.build();
    }

}
