package backend.study.adapterpattern.user.service;

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

    public String register(RegisterRequestDto registerRequestDto) {

        String encryptPassword = encryptUtil.encryptBCrypt(registerRequestDto.getPassword());

        UserAccountEntity account = UserAccountEntity.createUserEntity(
            registerRequestDto.getUserId(), registerRequestDto.getUsername(),
            registerRequestDto.getEmail(), encryptPassword
        );

        userAccountRepository.save(account);

        return "회원가입 성공";
    }

}
//$2a$10$ub9v6iHyEs9AqYnRer9TTeU5slKQvrx50ag8VV4axEflqx4jeKCpi
//$2a$10$yUh9M8agcEX2cH0eD0AbCeCihSy1ofb5Eeru9MG6eJtdUdML4RUvS