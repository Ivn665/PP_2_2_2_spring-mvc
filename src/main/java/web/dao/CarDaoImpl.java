package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Changan CS75FL", 150, 180));
        cars.add(new Car("Exeed VX", 249, 195));
        cars.add(new Car("DFM Dongfeng 580", 132, 195));
        cars.add(new Car("Chery Tiggo 7 Pro", 147, 186));
        cars.add(new Car("FAW Bestune T77", 160, 186));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getCarsByQuantity(int quantity) {
        if (quantity > cars.size()) {
            quantity = cars.size();
        }
        return new ArrayList<>(cars.subList(0, quantity));
    }
}
