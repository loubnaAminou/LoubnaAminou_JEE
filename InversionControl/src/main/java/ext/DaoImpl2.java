package ext;

import dao.IDao;
import org.springframework.stereotype.Component;

@Component(value = "daoCapteur")
public class DaoImpl2 implements IDao {
    @Override
    public double getData() {
        System.out.println("Version capteur");
        double temp = 1000;
        return temp;
    }
}
