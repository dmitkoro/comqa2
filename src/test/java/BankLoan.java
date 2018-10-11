import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BankLoan {

    private String text;

    @Test
    public void OurFirstTest() {


        Integer loan = 30000;
        Integer ExpectedTotalAmount = 102000;


        Integer decade = 10;
        Integer firstperiod = loan * 10 / 100 * decade;
        Integer secondperiod = loan * 8 / 100 * decade;
        Integer thirdperiod = loan * 6 / 100 * decade;
        Integer totalamount = loan + firstperiod + secondperiod + thirdperiod;


        assertEquals(ExpectedTotalAmount, totalamount, "Wrong sum !");
        text = "Correct sum : ";
        System.out.println(text + totalamount);


    }


}
