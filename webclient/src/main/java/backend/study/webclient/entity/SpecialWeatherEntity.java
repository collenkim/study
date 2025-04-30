package backend.study.webclient.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "special_weather")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SpecialWeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "stn_id", nullable = false)
    private String stnId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "announcement_time", nullable = false)
    private LocalDateTime announcementTime;

    @Column(name = "announcement_seq", nullable = false)
    private Integer announcementSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weather_entity_id", nullable = false)
    private WeatherEntity weatherEntity;

    private SpecialWeatherEntity(WeatherEntity weatherEntity,
        String stnId, String title, LocalDateTime announcementTime, Integer announcementSeq) {
        this.weatherEntity = weatherEntity;
        this.stnId = stnId;
        this.title = title;
        this.announcementTime = announcementTime;
        this.announcementSeq = announcementSeq;
    }

    /**
     * 특별 기상 정보 객체 생성
     *
     * @param weatherEntity
     * @param stnId
     * @param title
     * @param announcementTime
     * @param announcementSeq
     * @return
     */
    public static SpecialWeatherEntity createSpecialWeatherEntity(
        WeatherEntity weatherEntity,
        String stnId, String title, LocalDateTime announcementTime, Integer announcementSeq) {
        return new SpecialWeatherEntity(weatherEntity, stnId, title, announcementTime,
            announcementSeq);
    }

}
