import Third_Party.AxisBankAPI;

public class AxisBankAPIAdapter implements BankAPI
{
    private AxisBankAPI axisBankAPI;
    public AxisBankAPIAdapter()
    {
        this.axisBankAPI=axisBankAPI;
    }
    public double checkBalance(String UPIID,int pin)
    {
        return axisBankAPI.getBalance(UPIID,pin);
    }
    public void addNewBankAccount(String bankAccountNumber,
                           String debitCardNumber,
                           int pin,
                           int otp)
    {
        axisBankAPI.addNewAccount(bankAccountNumber,debitCardNumber,pin,otp);
    }
    public int makePayment(String fromUPIID,String toUPIID,double amount,int pin)
    {
        char statusCode=axisBankAPI.transferPayment(fromUPIID,toUPIID,amount,pin);
        if(statusCode=='Y')// It is done
        {
            System.out.println("Payment is successful");
            return 1;
        }
        else if (statusCode=='I')// In Progress
        {
            System.out.println("Payment is in progress");
            return 0;
        }
        else // Failed
        {
            System.out.println("Payment failed");
            return 2;
        }
    }
}
