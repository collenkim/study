package backend.study.adapterpattern.login.api;

import backend.study.adapterpattern.login.dto.LoginResponseDto;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/oauth2")
public class SocialLoginApi {


    @PostMapping("/{provider}/login")
    public LoginResponseDto socialLogin(@PathVariable("provider") String provider) {

    }


    @PostMapping("/{provider}/signup")
    public LoginResponseDto socialSignup(@PathVariable("provider") String provider) {

    }

    
    @PostMapping("/{provider}/logout")
    public LoginResponseDto socialLogout(@PathVariable("provider") String provider) {

    }

}
