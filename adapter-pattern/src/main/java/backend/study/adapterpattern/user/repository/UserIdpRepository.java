package backend.study.adapterpattern.user.repository;

import backend.study.adapterpattern.login.cd.ProviderCd;
import backend.study.adapterpattern.user.domain.UserIdpEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserIdpRepository extends JpaRepository<UserIdpEntity, Long> {

    Optional<UserIdpEntity> findByProviderAndProviderId(ProviderCd provider, String providerId);

}
