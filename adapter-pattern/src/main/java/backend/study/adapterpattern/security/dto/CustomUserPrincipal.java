package backend.study.adapterpattern.security.dto;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

@ToString
@AllArgsConstructor
public class CustomUserPrincipal implements UserDetails, OAuth2User {

    private final String id;
    private final String username;
    private final String email;
    private final String password;
    private final boolean enabled;

    private final Map<String, Object> attributes;

    public CustomUserPrincipal(String id, String username, String email, String password,
        boolean enabled) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.attributes = Map.of(); // 소셜 아님
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정의 잠금 여부
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 자격 증명의 만료 여부
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attributes;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String getName() {
        return this.id;
    }
}
