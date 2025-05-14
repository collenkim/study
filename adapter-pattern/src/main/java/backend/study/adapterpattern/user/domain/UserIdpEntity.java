package backend.study.adapterpattern.user.domain;

import backend.study.adapterpattern.login.cd.ProviderCd;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@DynamicUpdate
@Getter
@Entity
@Table(name = "user_idp",
    indexes = {
        @Index(name = "idx_provider_id", columnList = "provider_id")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserIdpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "provider", nullable = false)
    private ProviderCd provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "provider_id", nullable = false)
    private String providerId;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    private UserIdpEntity(ProviderCd provider, UserEntity user, String email, String providerId) {
        this.provider = provider;
        this.user = user;
        this.email = email;
        this.providerId = providerId;
    }

    public static UserIdpEntity createUserIdpEntity(ProviderCd provider, UserEntity user,
        String email, String providerId) {
        return new UserIdpEntity(provider, user, email, providerId);
    }

    public void deleteUserIdp() {
        this.deletedAt = LocalDateTime.now();
    }

}
