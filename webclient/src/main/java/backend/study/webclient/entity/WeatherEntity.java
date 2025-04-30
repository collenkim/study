package backend.study.webclient.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "weather")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "weather_type", nullable = false)
    private String weatherType;

    @Column(name = "stn_id", nullable = false)
    private String stnId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createedAt;

    private WeatherEntity(String weatherType, String stnId, LocalDateTime createedAt) {
        this.weatherType = weatherType;
        this.stnId = stnId;
        this.createedAt = createedAt;
    }

    /**
     * 기상 정보 객체 생성
     *
     * @param weatherType
     * @param stnId
     * @param createedAt
     * @return
     */
    public static WeatherEntity createWeatherEntity(String weatherType, String stnId,
        LocalDateTime createedAt) {
        return new WeatherEntity(weatherType, stnId, createedAt);
    }
}
