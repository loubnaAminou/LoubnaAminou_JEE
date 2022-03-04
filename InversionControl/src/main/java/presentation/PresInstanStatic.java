package presentation;

import ext.DaoImpl2;
import dao.DaoImpl;
import metier.MetierImpl;

// Factoring : fabrication/instanciation des objets
public class PresInstanStatic {
    public static void main(String[] args) {
        // Couplage fort
        DaoImpl dao = new DaoImpl();
        DaoImpl2 daoCapteur = new DaoImpl2();
        MetierImpl metier = new MetierImpl(dao);
        //System.out.println(metier.calcul());

        /*
        1st exec : NullPointerException => dao is not initialized
        */

        /*
        Injection des dépendances par instanciation statique
        => new : couplage fort
        */

        //metier.setDao(daoCapteur);
        System.out.println(metier.calcul());
    }
}
