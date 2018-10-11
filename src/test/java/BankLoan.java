import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


import static org.junit.jupiter.api.Assertions.assertTrue;


public class BankLoan {

    private String text;

    @Test
    public void OurFirstTest() {


        //Введите сумму заёма и сумму которую вы планируете отдать
        BigDecimal loan = new BigDecimal(3415565);
        BigDecimal expectedTotalAmount = new BigDecimal(9025272);






        BigDecimal yearsToMonths = new BigDecimal(360);
        BigDecimal averagePercentfor30Years = new BigDecimal(0.08);
        BigDecimal one = new BigDecimal(1);


        //1. Процентная ставка по кредиту в месяц = годовая процентная ставка / 12 месяцев 8%/12 месяцев/100.
        BigDecimal monthAmount = new BigDecimal(12);
        BigDecimal monthlyPercent = averagePercentfor30Years.divide(monthAmount, MathContext.DECIMAL32);



        //2. Коэффициент аннуитета = (0.0.006666667*(1+0.006666667)^360)/((1+0.006666667)^360—1).
        BigDecimal percentsForFirstDecadePart1 = monthlyPercent.add(one).pow(360, MathContext.DECIMAL32).multiply(monthlyPercent);
        BigDecimal percentsForFirstDecadePart2 = monthlyPercent.add(one).pow(360, MathContext.DECIMAL32).subtract(one);
        BigDecimal coefficient = percentsForFirstDecadePart1.divide(percentsForFirstDecadePart2, MathContext.DECIMAL32).round(new MathContext(3, RoundingMode.HALF_UP));


        text = "Here is a sum you have to pay within 30 years : ";
        BigDecimal monthlySumToPay = coefficient.multiply(loan).round(new MathContext(6, RoundingMode.HALF_UP));
        BigDecimal sumToPayForAllPeriod = monthlySumToPay.multiply(yearsToMonths);
        System.out.println(text + sumToPayForAllPeriod);


        assertTrue(expectedTotalAmount.compareTo(sumToPayForAllPeriod) == 0);



    }


}
