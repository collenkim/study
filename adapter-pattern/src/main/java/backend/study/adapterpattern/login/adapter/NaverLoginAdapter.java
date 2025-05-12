package backend.study.adapterpattern.login.adapter;

import backend.study.adapterpattern.login.cd.ProviderCd;
import org.springframework.stereotype.Component;

@Component
public class NaverLoginAdapter implements SocialLoginAdapter {

    @Override
    public ProviderCd getProviderCd() {
        return ProviderCd.NAVER;
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
