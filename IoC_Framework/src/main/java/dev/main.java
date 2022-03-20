package dev;

import dev.metier.IMetier;
import dev.metier.MetierImpl;
import framework.ClassPathXmlAppContext;
import framework.IoCAnnotation;

import javax.xml.bind.JAXBException;



public class main {
    public static void main(String[] args)  throws JAXBException{
        /*
        * Jax binding config
        * */
        ClassPathXmlAppContext context = new ClassPathXmlAppContext("ApplicationContext.xml");
        MetierImpl metier = (MetierImpl) context.getBean(MetierImpl.class);

        /*
        * Annotation config
        * */
        Class<?> aClass = new MetierImpl().getClass();
        IoCAnnotation annotation = aClass.getAnnotation(IoCAnnotation.class);


    }
}
