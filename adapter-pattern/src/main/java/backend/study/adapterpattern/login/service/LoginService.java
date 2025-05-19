package backend.study.adapterpattern.login.service;

import backend.study.adapterpattern.login.cd.ProviderCd;
import backend.study.adapterpattern.login.dto.LoginRequestDto;
import backend.study.adapterpattern.login.dto.LoginResponseDto;
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

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        isValidLoginUser(loginRequestDto);

        String accessToken = jwtUtil.accessToken(loginRequestDto.getUsername());
        String refreshToken = jwtUtil.refreshToken(loginRequestDto.getUsername());
        return new LoginResponseDto(accessToken, refreshToken, ProviderCd.BASIC.getProvider());
    }

    /**
     * 로그인 유저 검증
     *
     * @param loginRequestDto
     */
    private void isValidLoginUser(LoginRequestDto loginRequestDto) {

        Optional<UserAccountEntity> userAccount = userAccountRepository.findByUserId(
            loginRequestDto.getUsername());

        if (userAccount.isEmpty()) {
            throw new BadCredentialsException("아이디 또는 비밀번호가 올바르지 않습니다");
        } else {
            if (!encryptUtil.matchesBCrypt(loginRequestDto.getPassword(),
                userAccount.get().getPassword())) {
                throw new BadCredentialsException("아이디 또는 비밀번호가 올바르지 않습니다");
            }
        }

    }

}
