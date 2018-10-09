import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


    public class BankLoan {

    private String text;

    @Test
    public void OurFirstTest() {


        BigDecimal loan = new BigDecimal (30000);

        BigDecimal decade = new BigDecimal(10);
        BigDecimal firstPercent = new BigDecimal(0.1);
        BigDecimal secondPercent = new BigDecimal(0.08);
        BigDecimal thirdPercent = new BigDecimal(0.06);

        BigDecimal firstPeriod = loan.multiply(firstPercent).multiply(decade);
        BigDecimal secondPeriod = loan.multiply(secondPercent).multiply(decade);
        BigDecimal thirdPeriod = loan.multiply(thirdPercent).multiply(decade);

        BigDecimal totalAmount = loan.add(firstPeriod).add(secondPeriod).add(thirdPeriod);


        BigDecimal expectedTotalAmount = new BigDecimal (102000);


        assertEquals(expectedTotalAmount,totalAmount,"Wrong sum !");
        text = "Correct sum : ";
        System.out.println(text + totalAmount);


    }


}
