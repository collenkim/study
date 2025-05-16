package backend.study.adapterpattern.user.repository;

import backend.study.adapterpattern.user.domain.UserAccountEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserAccountEntity, Long> {

    Optional<UserAccountEntity> findByUserId(String userId);

}
