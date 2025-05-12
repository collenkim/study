package backend.study.adapterpattern.login.factory;

import backend.study.adapterpattern.login.adapter.SocialLoginAdapter;
import backend.study.adapterpattern.login.cd.ProviderCd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class SocialLoginAdapterFactory {

    private final Map<ProviderCd, SocialLoginAdapter> adapterMap = new HashMap<>();

    public SocialLoginAdapterFactory(List<SocialLoginAdapter> adapters) {
        for (SocialLoginAdapter adapter : adapters) {
            ProviderCd provider = adapter.getProviderCd();
            adapterMap.put(provider, adapter);
        }
    }

    public SocialLoginAdapter getAdapter(String provider) {

        ProviderCd.isValidProvider(provider);

        return adapterMap.get(provider);
    }

}
