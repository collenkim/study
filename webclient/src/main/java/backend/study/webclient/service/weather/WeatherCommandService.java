package backend.study.webclient.service.weather;

import backend.study.webclient.entity.WeatherEntity;
import backend.study.webclient.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherCommandService {

    private final WeatherRepository weatherRepository;

    /**
     * Weather 정보를 저장하는 메소드
     *
     * @param weather
     */
    @Transactional
    public void createWeather(WeatherEntity weather) {
        weatherRepository.save(weather);
    }

}
