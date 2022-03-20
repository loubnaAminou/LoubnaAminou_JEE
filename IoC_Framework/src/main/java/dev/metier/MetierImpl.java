package dev.metier;

import framework.IoCAnnotation;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Calendar;
@XmlRootElement
@IoCAnnotation("metier")
public class MetierImpl implements IMetier{
    private int myAge;

    public MetierImpl() {
        compute();
    }

    @Override
    public void compute() {
        System.out.println("Let's calculate my age :");
        int birthYear = 2001;
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        this.myAge = currentYear - birthYear;
        System.out.println("So ... I'm "+this.myAge+ " years old");
    }

}
