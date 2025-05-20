package backend.study.adapterpattern.login.api;

import backend.study.adapterpattern.login.dto.LoginRequestDto;
import backend.study.adapterpattern.login.dto.LoginResponseDto;
import backend.study.adapterpattern.login.dto.RegisterRequestDto;
import backend.study.adapterpattern.login.service.LoginService;
import backend.study.adapterpattern.user.service.UserAccountService;
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
    private final UserAccountService userAccountService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(
        @RequestBody @Valid LoginRequestDto loginRequestDto) {
        return ResponseEntity.ok(loginService.login(loginRequestDto));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody @Valid RegisterRequestDto registerRequestDto) {
        userAccountService.register(registerRequestDto);
        return ResponseEntity.ok("회원가입 성공");
    }

    @PostMapping("/logout")
    public LoginResponseDto logout() {
        return new LoginResponseDto();
    }


}
