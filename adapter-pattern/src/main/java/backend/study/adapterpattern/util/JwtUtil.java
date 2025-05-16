package backend.study.adapterpattern.util;

import backend.study.adapterpattern.error.exception.ExpiredTokenException;
import backend.study.adapterpattern.error.exception.InvalidSignatureException;
import backend.study.adapterpattern.error.exception.InvalidTokenException;
import backend.study.adapterpattern.error.exception.MalformedTokenException;
import backend.study.adapterpattern.error.exception.UnknownTokenException;
import backend.study.adapterpattern.error.exception.UnsupportedTokenException;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import java.time.Duration;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey signingKey;

    /**
     * JWT 토큰 생성
     */
    public String generateToken(String username) {

        Date currentAt = new Date();
        Date expiredAt = new Date(currentAt.getTime() + Duration.ofMinutes(30).toMillis());

        return Jwts.builder()
            .subject(username)
            .issuedAt(currentAt)
            .expiration(expiredAt)
            .signWith(signingKey, Jwts.SIG.HS256)
            .compact();
    }

    /**
     * JWT 토큰에서 사용자 ID 추출
     *
     * @param token
     * @return
     */
    public String getUserIdFromToken(String token) {
        return Jwts.parser()
            .verifyWith(signingKey)
            .build()
            .parseSignedClaims(token)
            .getPayload().getSubject();
    }

    /**
     * JWT 토큰 검증 메서드
     *
     * @param token
     * @return
     */
    public boolean validateToken(String token) {

        try {

            Jwts.parser()
                .verifyWith(signingKey) // 서명 검증
                .build()
                .parseSignedClaims(token); // 토큰 파싱

            return true;

        } catch (ExpiredJwtException e) {
            throw new ExpiredTokenException("Expired JWT token", e);
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedTokenException("Unsupported JWT token", e);
        } catch (MalformedJwtException e) {
            throw new MalformedTokenException("Invalid JWT token format", e);
        } catch (SecurityException e) {
            throw new InvalidSignatureException("Invalid JWT signature", e);
        } catch (JwtException e) {
            throw new InvalidTokenException("Invalid JWT token", e);
        } catch (Exception e) {
            throw new UnknownTokenException("Unknown error while parsing JWT token", e);
        }
    }

    @PostConstruct
    public void init() {
        this.signingKey = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

}
