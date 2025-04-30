package backend.study.webclient.service.specialweather;

import backend.study.webclient.repository.SpecialWeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialWeatherQueryService {

    private final SpecialWeatherRepository specialWeatherRepository;


}
