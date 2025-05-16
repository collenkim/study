package backend.study.adapterpattern.login.domain;

import backend.study.adapterpattern.login.cd.LoginResultType;
import backend.study.adapterpattern.login.cd.LoginType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Entity
@Table(name = "login_hist",
    indexes = {
        @Index(name = "idx_login_type", columnList = "login_type"),
        @Index(name = "idx_login_hist_user_id", columnList = "user_id")
        //h2 db에서는 인덱스 관리를 스키마 단위로 하기 때문에 정정
    })
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LoginHistEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "login_type", nullable = false, length = 20)
    private LoginType loginType;

    @Column(name = "user_id")
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "login_result_type", nullable = false)
    private LoginResultType loginResultType;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "user_agent")
    private String userAgent;

    @CreationTimestamp
    @Column(name = "login_at")
    private LocalDateTime loginAt;

    private String failMessage;


    private LoginHistEntity(LoginType loginType, String userId, LoginResultType loginResultType,
        String loginIp, String userAgent, String failMessage) {
        this.loginType = loginType;
        this.userId = userId;
        this.loginResultType = loginResultType;
        this.loginIp = loginIp;
        this.userAgent = userAgent;
        this.failMessage = failMessage;
    }

    public static LoginHistEntity createLoginHistEntity(LoginType loginType, String userId,
        LoginResultType loginResultType,
        String loginIp, String userAgent, String failMessage) {
        return new LoginHistEntity(loginType, userId, loginResultType, loginIp, userAgent,
            failMessage);
    }

}
