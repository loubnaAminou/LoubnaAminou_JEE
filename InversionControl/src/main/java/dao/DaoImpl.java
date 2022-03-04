package dao;

import org.springframework.stereotype.Component;

@Component(value = "dao")
public class DaoImpl implements IDao{
    @Override
    public double getData() {
        System.out.println("Version DB");
        /*
        * Se connecter à la DB => temp = getTemp()
        * */
        double temp = Math.random()*40;
        return temp;
    }

    public void init(){
        System.out.println("Instanciation de Dao Impl");
    }
}
