import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


    public class BankLoan {

    private String text;

    @Test
    public void OurFirstTest() {


        Integer loan = 30000;

        Integer firstperiod = loan * 10 / 100 * 10;
        Integer secondperiod = loan * 8 / 100 * 10;
        Integer thirdperiod = loan * 6 / 100 * 10;
        Integer totalamount = loan + firstperiod + secondperiod + thirdperiod;

        Integer ExpectedTotalAmount = 102000;


        assertEquals(ExpectedTotalAmount,totalamount,"Wrong sum !");
        text = "Correct sum : ";
        System.out.println(text + totalamount);



    }


}
