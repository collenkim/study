package backend.study.adapterpattern.login.adapter;

import backend.study.adapterpattern.login.cd.ProviderCd;
import org.springframework.stereotype.Component;

@Component
public class GoogleLoginAdapter implements SocialLoginAdapter {

    @Override
    public ProviderCd getProviderCd() {
        return ProviderCd.GOOGLE;
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
