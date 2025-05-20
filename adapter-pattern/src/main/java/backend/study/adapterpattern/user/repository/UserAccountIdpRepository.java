package backend.study.adapterpattern.user.repository;

import backend.study.adapterpattern.login.cd.ProviderCd;
import backend.study.adapterpattern.user.domain.UserAccountIdpEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountIdpRepository extends JpaRepository<UserAccountIdpEntity, Long> {

    Optional<UserAccountIdpEntity> findByProviderAndProviderId(ProviderCd provider,
        String providerId);

}
