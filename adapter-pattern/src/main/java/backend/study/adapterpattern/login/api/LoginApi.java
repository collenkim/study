package backend.study.adapterpattern.login.api;

import backend.study.adapterpattern.login.dto.LoginResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginApi {

    @PostMapping("/token")
    public LoginResponseDto login() {
        return new LoginResponseDto();
    }

    @PostMapping("/signup")
    public LoginResponseDto signup() {
        return new LoginResponseDto();
    }

    @PostMapping("/logout")
    public LoginResponseDto logout() {
        return new LoginResponseDto();
    }


}
