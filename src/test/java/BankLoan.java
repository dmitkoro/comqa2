import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class BankLoan {

    private String text;

    @Test
    public void OurFirstTest() {


        BigDecimal loan = new BigDecimal (250000);

        BigDecimal decade = new BigDecimal(10);
        BigDecimal firstPercent = new BigDecimal(0.1);
        BigDecimal secondPercent = new BigDecimal(0.08);
        BigDecimal thirdPercent = new BigDecimal(0.06);

        BigDecimal firstPeriod = loan.multiply(firstPercent).multiply(decade);
        BigDecimal secondPeriod = loan.multiply(secondPercent).multiply(decade);
        BigDecimal thirdPeriod = loan.multiply(thirdPercent).multiply(decade);

        BigDecimal totalAmount = loan.add(firstPeriod).add(secondPeriod).add(thirdPeriod).round(new MathContext(15, RoundingMode.HALF_UP));
        System.out.println("Expected sum is : " + totalAmount);



        BigDecimal expectedTotalAmount = new BigDecimal (850000);



         assertTrue(expectedTotalAmount.compareTo(totalAmount)==0);

        text = "Correct sum : ";
        System.out.println(text + totalAmount);


    }


}
