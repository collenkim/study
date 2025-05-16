package backend.study.adapterpattern.login.api;

import backend.study.adapterpattern.login.dto.LoginResponseDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class SocialLoginApi {


    @PostMapping("/{provider}/token")
    public LoginResponseDto socialLogin(@PathVariable("provider") String provider) {
        return new LoginResponseDto();
    }


    @PostMapping("/{provider}/signup")
    public LoginResponseDto socialSignup(@PathVariable("provider") String provider) {
        return new LoginResponseDto();
    }


    @PostMapping("/{provider}/logout")
    public LoginResponseDto socialLogout(@PathVariable("provider") String provider) {
        return new LoginResponseDto();
    }

}
