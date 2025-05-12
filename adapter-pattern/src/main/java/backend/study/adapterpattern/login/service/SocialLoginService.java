package backend.study.adapterpattern.login.service;

import backend.study.adapterpattern.login.adapter.SocialLoginAdapter;
import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocialLoginService {

    private final Map<String, SocialLoginAdapter> socialLoginAdapterMap = new HashMap<>();


}
