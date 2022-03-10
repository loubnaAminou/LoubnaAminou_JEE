package dev;

import dev.metier.IMetier;
import dev.metier.MetierImpl;
import framework.ClassPathXmlAppContext;

import javax.xml.bind.JAXBException;

public class main {
    public static void main(String[] args)  throws JAXBException{
        ClassPathXmlAppContext context = new ClassPathXmlAppContext("ApplicationContext.xml");
        MetierImpl metier = (MetierImpl) context.getBean(MetierImpl.class);

    }
}
