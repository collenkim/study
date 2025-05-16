package backend.study.adapterpattern.security.service;

import backend.study.adapterpattern.security.dto.CustomUserPrincipal;
import backend.study.adapterpattern.user.domain.UserAccountEntity;
import backend.study.adapterpattern.user.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 데이터베이스에서 이메일을 기반으로 사용자 정보를 조회
        Optional<UserAccountEntity> user = userRepository.findByUserId(username);

        if (user.isEmpty()) {
            // 사용자가 없을 경우 예외처리
            log.error("User not found (username: {})", username);
            throw new UsernameNotFoundException(username + " 가입된 사용자가 없습니다");
        }

        boolean enabled = user.get().getDeletedAt() == null;

        // CustomUserDetails 객체를 생성하여 반환
        return new CustomUserPrincipal(user.get().getUserId(),
            user.get().getUserName(), user.get().getEmail(), user.get().getPassword(),
            enabled);
    }


}
