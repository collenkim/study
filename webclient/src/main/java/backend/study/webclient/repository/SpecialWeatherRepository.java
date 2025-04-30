package backend.study.webclient.repository;

import backend.study.webclient.entity.SpecialWeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialWeatherRepository extends JpaRepository<SpecialWeatherEntity, Long> {

}
