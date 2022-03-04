package presentation;

import metier.IMetier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PresSpringXml {
    public static void main(String[] args) {
        // demander au Spring dès le démarrage de l'application de lire le fichier XML
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        /*
        * La création des objets est effectuée par SpringContainer. Dieu merci !
        * */

        //Demander à l'application un objet déjà créé : référence
        //IMetier metier = (IMetier) context.getBean("metier");
        IMetier metier = context.getBean(IMetier.class); // !!! Une seule implémentation pour cette interface. Sinon => exception
        System.out.println(metier.calcul());

    }
}
