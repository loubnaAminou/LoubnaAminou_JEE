package metier;

import org.junit.Assert;
import org.junit.Test;

public class CalculTest {

    private Calcul calcul;
    @Test
    public void testSum(){
        // Scenario de test
        calcul = new Calcul();
        double a=5, b = 9;
        double expected = 14;
        double res = calcul.sum(a, b);
        Assert.assertTrue(res == expected);
    }
}
