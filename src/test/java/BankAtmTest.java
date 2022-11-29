import CustomExceptions.AmountCreditException;
import CustomExceptions.AmountDebitException;
import CustomExceptions.MinimumBalanceException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BankAtmTest {

    @Test
    void shouldCheckForPositiveValueOfAmountCredited()
    {
        BankAtm bankAtm=new BankAtm();
        bankAtm.setAmountCredit(10000);
        double actualValue=bankAtm.getAmountCredit();
        double expectedValue=10000;
        assertEquals(expectedValue,actualValue);

    }
    @Test
    void shouldCheckForPositiveValueOfAmountDebited()
    {
        BankAtm bankAtm=new BankAtm();
        bankAtm.setAmountDebit(10000);
        double actualValue=bankAtm.getAmountDebit();
        double expectedValue=10000;
        assertEquals(expectedValue,actualValue);

    }
    @Test
    void shouldThrowIllegalArgumentExceptionWhenNegativeAmountIsCredited()throws IllegalArgumentException
    {
        BankAtm bankAtm=new BankAtm();
        bankAtm.setAmountCredit(-10000);
        IllegalArgumentException ex= Assertions.assertThrows(IllegalArgumentException.class, bankAtm::getAmountCredit);
        String actualValue=ex.getMessage();
        String expectedValue="Invalid Amount to be credited";
        assertEquals(expectedValue,actualValue);

    }

    @Test
    void shouldThrowMinimumBalanceExceptionWhenAmountIsLessThanFifteenThousand()throws MinimumBalanceException
    {
        BankAtm bankAtm=new BankAtm();
        MinimumBalanceException mb=Assertions.assertThrows(MinimumBalanceException.class, bankAtm::showTotalBalance);
        String actualValue=mb.getMessage();
        String expectedValue="Balance cannot be less than 15000 please deposit some amount";
        assertEquals(expectedValue,actualValue);

    }
    @Test
    void shouldThrowAmountCreditExceptionWhenAmountCreditedIsMoreThanOneLakh()throws AmountCreditException
    {
        BankAtm bankAtm=new BankAtm();
        AmountCreditException ac=Assertions.assertThrows(AmountCreditException.class,()-> bankAtm.amountCredit(150000));
        String actualValue=ac.getMessage();
        String expectedValue="Amount Credited should be less than 100000";
        assertEquals(expectedValue,actualValue);

    }
    @Test
    void shouldThrowAmountDebitExceptionWhenAmountDebitedIsMoreThanOneLakh()throws AmountDebitException
    {
        BankAtm bankAtm=new BankAtm();
        AmountDebitException ab=Assertions.assertThrows(AmountDebitException.class,()-> bankAtm.amountDebit(150000));
        String actualValue=ab.getMessage();
        String expectedValue="Amount Debited should be less than 100000";
        assertEquals(expectedValue,actualValue);

    }

}
