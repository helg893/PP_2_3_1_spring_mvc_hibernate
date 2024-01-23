package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.CarDao;
import web.model.Car;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    private final CarDao carDao;

    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
        carDao.add(new Car(0, "modelOne", 1000));
        carDao.add(new Car(1, "modelTwo", 2000));
        carDao.add(new Car(2, "model3", 3000));
        carDao.add(new Car(3, "modelFour", 4000));
        carDao.add(new Car(4, "model5", 5000));
    }

    @Override
    public void add(Car car) {
        carDao.add(car);
    }

    @Override
    public List<Car> getCars(int count) {
        return carDao.getCars(count);
    }
}
