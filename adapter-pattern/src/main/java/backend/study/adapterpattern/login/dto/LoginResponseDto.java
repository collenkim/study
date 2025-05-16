package backend.study.adapterpattern.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    private String accessToken;
    private String refreshToken;
    private String provider;

}
