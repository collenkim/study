package backend.study.adapterpattern.user.service;

import backend.study.adapterpattern.error.exception.UserAlreadyExistsException;
import backend.study.adapterpattern.login.dto.RegisterRequestDto;
import backend.study.adapterpattern.user.domain.UserAccountEntity;
import backend.study.adapterpattern.user.repository.UserAccountRepository;
import backend.study.adapterpattern.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserAccountService {

    private final EncryptUtil encryptUtil;
    private final UserAccountRepository userAccountRepository;

    /**
     * 일반 회원가입
     *
     * @param registerRequestDto
     * @return
     */
    public void register(RegisterRequestDto registerRequestDto) {

        String encryptPassword = encryptUtil.encryptBCrypt(registerRequestDto.getPassword());

        if (userAccountRepository.findByUserId(registerRequestDto.getUserId()).isPresent()) {
            throw new UserAlreadyExistsException("이미 존재하는 아이디입니다");
        }

        UserAccountEntity account = UserAccountEntity.createUserEntity(
            registerRequestDto.getUserId(), registerRequestDto.getUsername(),
            registerRequestDto.getEmail(), encryptPassword
        );

        userAccountRepository.save(account);
    }

}