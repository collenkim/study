package backend.study.adapterpattern.user.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

@DynamicUpdate
@Getter
@Entity
@Table(name = "user_account",
    indexes = {
        @Index(name = "idx_user_account_user_id", columnList = "user_id"),
        //h2 db에서는 인덱스 관리를 스키마 단위로 하기 때문에 정정
        @Index(name = "idx_created_at", columnList = "created_at"),
        @Index(name = "idx_deleted_at", columnList = "deleted_at")
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "useer_name")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    private UserAccountEntity(String userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    private UserAccountEntity(String userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public static UserAccountEntity createUserEntity(String userId, String userName, String email,
        String password) {
        return new UserAccountEntity(userId, userName, email, password);
    }

    public static UserAccountEntity createUserEntity(String userId, String userName, String email) {
        return new UserAccountEntity(userId, userName, email);
    }

    public void deleteUserI() {
        this.deletedAt = LocalDateTime.now();
    }

}
