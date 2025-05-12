package backend.study.adapterpattern.login.adapter;

import backend.study.adapterpattern.login.cd.ProviderCd;

public interface SocialLoginAdapter {

    ProviderCd getProviderCd();

    void login();

    void signup();

    void logout();

}
