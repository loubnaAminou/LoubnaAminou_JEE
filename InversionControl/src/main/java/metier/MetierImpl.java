package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "metier")
public class MetierImpl implements IMetier {
    @Autowired
    private IDao dao; // couplage faible => implémentation d'interface
    /*
    Si couplage fort : initialiser le dao par la classe DaoImpl
            */

    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double tmp = dao.getData();
        double res = tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }

    /*
    * Injecter dans la variable Dao un objet d'une classe qui implémente l'interface IDAO
    * */
    public void setDao(IDao dao) {
        System.out.println("Injection des dépendances ");
        this.dao = dao;
    }

    public void init(){
        System.out.println("Instanciation de Metier Impl");
    }
}
