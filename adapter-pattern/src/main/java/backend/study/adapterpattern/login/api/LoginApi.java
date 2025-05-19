package backend.study.adapterpattern.login.api;

import backend.study.adapterpattern.login.dto.LoginRequestDto;
import backend.study.adapterpattern.login.dto.LoginResponseDto;
import backend.study.adapterpattern.login.service.LoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class LoginApi {

    private final LoginService loginService;

    @PostMapping("/token")
    public ResponseEntity<String> token(
        @RequestBody @Valid LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(loginService.getToken(loginRequestDto));
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
