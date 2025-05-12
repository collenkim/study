package backend.study.adapterpattern.login.api;

import backend.study.adapterpattern.login.dto.LoginResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class LoginApi {

    @PostMapping("/login")
    public LoginResponseDto login() {

    }

    @PostMapping("/signup")
    public LoginResponseDto signup() {

    }

    @PostMapping("/logout")
    public LoginResponseDto logout() {

    }


}
