import Third_Party.YesBankAPI;

public class YesBankAPIAdapter implements BankAPI
{
    private YesBankAPI yesBankAPI=new YesBankAPI();
    public YesBankAPIAdapter()
    {
        this.yesBankAPI= yesBankAPI;
    }
    public double checkBalance(String UPIID,int pin)
    {
        return Double.parseDouble(yesBankAPI.checkBalance(UPIID,String.valueOf(pin)));
    }
    public void addNewBankAccount(String bankAccountNumber,
                           String debitCardNumber,
                           int pin,
                           int otp)
    {
        yesBankAPI.addBankAccount(String.valueOf(pin),otp,bankAccountNumber,debitCardNumber);
    }
    public int makePayment(String fromUPIID,String toUPIID,double amount,int pin)
    {
        return yesBankAPI.makeTransfer(amount,pin,fromUPIID,toUPIID);
    }
}
