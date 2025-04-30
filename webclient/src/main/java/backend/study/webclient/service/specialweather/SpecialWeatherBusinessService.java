package backend.study.webclient.service.specialweather;

import backend.study.webclient.cd.WeatherTypeCd;
import backend.study.webclient.dto.specialweather.SpecialWeatherExternalResponse.SpecialWeatherExternalItem;
import backend.study.webclient.entity.SpecialWeatherEntity;
import backend.study.webclient.entity.WeatherEntity;
import backend.study.webclient.service.weather.WeatherCommandService;
import backend.study.webclient.util.DateUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpecialWeatherBusinessService {

    private final SpecialWeatherCommandService specialWeatherCommandService;
    private final SpecialWeatherQueryService specialWeatherQueryService;
    private final WeatherCommandService weatherCommandService;

    /**
     * 특별기상정보를 저장하는 메소드
     *
     * @param items
     * @return
     */
    @Transactional
    public void saveSpecialWeathers(Map<String, List<SpecialWeatherExternalItem>> items) {

        if (CollectionUtils.isEmpty(items)) {
            log.warn("No special weather items to save");
            return;
        }

        for (Map.Entry<String, List<SpecialWeatherExternalItem>> entry : items.entrySet()) {

            String stnId = entry.getKey();
            List<SpecialWeatherExternalItem> itemList = entry.getValue();

            // 메인 WeatherEntity 생성 및 저장
            WeatherEntity weatherEntity = WeatherEntity.createWeatherEntity(
                stnId,
                WeatherTypeCd.SPECIAL.getCode(),
                LocalDateTime.now()
            );

            weatherCommandService.createWeather(weatherEntity);

            // SpecialWeatherEntity 리스트 생성 및 저장
            List<SpecialWeatherEntity> specialWeatherList = itemList.stream()
                .map(item -> {
                    return SpecialWeatherEntity.createSpecialWeatherEntity(weatherEntity, stnId,
                        item.getTitle(), DateUtil.getLocalDateTimeFromLong(item.getTmFc()),
                        item.getTmSeq());

                }).toList();

            specialWeatherCommandService.createSpecialWeathers(specialWeatherList);
        }

    }

}
