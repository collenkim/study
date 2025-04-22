package backend.study.webclient.service;

import java.util.List;

abstract class AbstractWeatherService<T> {

    public abstract List<T> getList(Object param);

    public abstract void save(Object param);

    public abstract void update(Object param);

    public abstract void delete(Object param);
    
}
