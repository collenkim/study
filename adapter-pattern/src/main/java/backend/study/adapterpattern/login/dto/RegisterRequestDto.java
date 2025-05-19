package backend.study.adapterpattern.login.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterRequestDto {

    @NotBlank(message = "아이디는 필수입니다.")
    private String userId;

    private String username;

    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;

    private String email;
}
