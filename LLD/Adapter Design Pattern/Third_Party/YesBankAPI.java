package Third_Party;
public class YesBankAPI
{
    public String checkBalance(String upiDetails,String pin)
    {
        return "12345";
    }
    public int addBankAccount(String pin, int OTP, String bankAccountNumber,String debitCardNumber)
    {
        return 1;
        // 1 - means successful
        // 2 - failure
        // 3 - in progress
    }
    public int makeTransfer(double amount, int pin,String fromUPIID,String toUPIID)
    {
        System.out.println("Payment Successful");
        return 0;
    }
}
