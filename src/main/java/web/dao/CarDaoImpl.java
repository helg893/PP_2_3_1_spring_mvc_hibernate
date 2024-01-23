package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public void add(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getCars(int count) {
        return count > 0 & count < 5
                ? cars.stream().limit(count).toList()
                : cars.stream().toList();
    }
}
