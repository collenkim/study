package backend.study.webclient.service.specialweather;

import backend.study.webclient.entity.SpecialWeatherEntity;
import backend.study.webclient.repository.SpecialWeatherRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SpecialWeatherCommandService {

    private final SpecialWeatherRepository specialWeatherRepository;

    /**
     * 특별기상정보를 저장하는 메소드
     *
     * @param specialWeatherList
     */
    @Transactional
    public void createSpecialWeathers(List<SpecialWeatherEntity> specialWeatherList) {
        specialWeatherRepository.saveAll(specialWeatherList);
    }
}
