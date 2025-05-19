package backend.study.adapterpattern.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptUtil {

    private final BCryptPasswordEncoder passwordEncoder;

    public EncryptUtil() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String encryptBCrypt(String inputText) {
        return passwordEncoder.encode(inputText);
    }

    public boolean matchesBCrypt(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }

}
