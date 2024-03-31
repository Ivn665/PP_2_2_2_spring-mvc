import org.junit.Assert;
import org.junit.Test;
import web.dao.CarDao;
import web.dao.CarDaoImpl;
import web.model.Car;
import web.service.CarService;
import web.service.CarServiceImpl;

import java.util.List;

public class CarServiceTest {
    private final CarDao carDao = new CarDaoImpl();
    private final CarService carService = new CarServiceImpl(carDao);

    @Test
    public void  getCarsByQuantityTest() {
        int quantity = 3;
        List<Car> cars = carService.getCarsByQuantity(quantity);
        Assert.assertEquals("метод getCarsByQuantity возвращает неверный размер коллекции",
                quantity, cars.size());
    }
}
