package backend.study.adapterpattern.login.adapter;

import backend.study.adapterpattern.login.cd.ProviderCd;
import org.springframework.stereotype.Component;

@Component
public class KakaoLoginAdapter implements SocialLoginAdapter {

    @Override
    public ProviderCd getProviderCd() {
        return ProviderCd.KAKAO;
    }

    @Override
    public void login() {
        // ...
    }

    @Override
    public void signup() {
        // ...
    }

    @Override
    public void logout() {
        // ...
    }


}
