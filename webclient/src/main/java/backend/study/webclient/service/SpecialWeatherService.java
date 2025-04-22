package backend.study.webclient.service;

import backend.study.webclient.dto.SpecialWeatherDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecialWeatherService extends AbstractWeatherService {

    @Override
    public List<> getList(SpecialWeatherDto.ReqList param) {
        return List.of();
    }

    @Override
    public void save(Object param) {

    }

    @Override
    public void update(Object param) {

    }

    @Override
    public void delete(Object param) {

    }
}
