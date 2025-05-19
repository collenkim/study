package backend.study.adapterpattern.login.service;

import backend.study.adapterpattern.login.dto.LoginRequestDto;
import backend.study.adapterpattern.user.domain.UserAccountEntity;
import backend.study.adapterpattern.user.repository.UserAccountRepository;
import backend.study.adapterpattern.util.EncryptUtil;
import backend.study.adapterpattern.util.JwtUtil;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final JwtUtil jwtUtil;
    private final EncryptUtil encryptUtil;
    private final UserAccountRepository userAccountRepository;

    public String getToken(LoginRequestDto loginRequestDto) {

        String encryptPassword = encryptUtil.encryptBCrypt(loginRequestDto.getPassword());

        Optional<UserAccountEntity> userAccount = userAccountRepository.findByUserIdAndPassword(
            loginRequestDto.getUsername(),
            encryptPassword);

        if (userAccount.isEmpty()) {
            throw new BadCredentialsException("아이디 또는 비밀번호가 올바르지 않습니다");
        }

        return jwtUtil.generateToken(loginRequestDto.getUsername());
    }
}
