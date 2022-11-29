import CustomExceptions.AmountCreditException;
import CustomExceptions.AmountDebitException;
import CustomExceptions.MinimumBalanceException;

public class BankAtm {

    private double amountDebit;
    private double amountCredit;
    private double totalBalance;

    public double getAmountDebit() throws IllegalArgumentException
    {
        if(this.amountDebit>0)
          return amountDebit;
        else
            throw new IllegalArgumentException("Invalid Amount to be debited");
    }

    public void setAmountDebit(double amountDebit) {
        this.amountDebit = amountDebit;
    }

    public double getAmountCredit()throws IllegalArgumentException
    {
        if(this.amountCredit>0)
        return amountCredit;
        else
            throw new IllegalArgumentException("Invalid Amount to be credited");
    }

    public void setAmountCredit(double amountCredit) {
        this.amountCredit = amountCredit;
    }
    public void amountDebit(double debitAmount) throws AmountDebitException
    {
        if(debitAmount<100000){
            setAmountDebit(debitAmount);
            System.out.println(getAmountDebit()+" Amount debited Successfully");
            totalBalance=totalBalance-debitAmount;
        }
        else
            throw new AmountDebitException("Amount Debited should be less than 100000");
    }

    public void amountCredit(double creditAmount) throws AmountCreditException
    {
        if(creditAmount<100000){
            setAmountCredit(creditAmount);
            System.out.println(getAmountCredit()+" Amount credited Successfully");
            totalBalance=totalBalance+creditAmount;
        }
        else
            throw new AmountCreditException("Amount Credited should be less than 100000");
    }
    public void showTotalBalance()throws MinimumBalanceException
    {
        if(totalBalance>15000)
            System.out.println("The Total Balance is "+totalBalance);
        else{
            System.out.println("Current Balance is "+totalBalance);
            throw new MinimumBalanceException("Balance cannot be less than 15000 please deposit some amount");
        }
    }
}
