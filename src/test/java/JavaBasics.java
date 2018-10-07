import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaBasics {

  private String text;

  @Test
    public void OurFirstTest () {
    Integer a = 15;
    Integer b = 99;
    Integer c = 95;
    Integer d = 150;



    text = "The sum is : ";

    sumAndPrint(a,b);

       sumAndPrint(c,d);

      assertEquals(245, c + d, "Wrong sum !");

    }

    private void sumAndPrint(int a, int b){


    Integer sum = a + b;
      System.out.println(text + sum);

    }

}
