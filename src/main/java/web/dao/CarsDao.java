package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDao {
    private List<Car> cars;

    {
        cars = new ArrayList<>();

        cars.add(new Car("BMV", 5, "black"));
        cars.add(new Car("Citroen", 6, "red"));
        cars.add(new Car("Volvo", 4, "white"));
        cars.add(new Car("Renault", 3, "green"));
        cars.add(new Car("Toyota", 2, "blue"));
    }

    public List<Car> getAll() {
        return cars;
    }

    public List<Car> getBy(int quantity) {
        if (quantity < 5 ) {
            return cars.stream().limit(quantity).toList();
        } else {
            return cars;
        }
    }
}
