public class PhonePe
{
    private BankAPI bankAPI;
    public PhonePe(BankAPI bankAPI)
    {
        this.bankAPI=bankAPI;
    }
    public void paymentResults(String fromUPIID,String toUPIID,double amount,int pin)
    {
        bankAPI.makePayment(fromUPIID,toUPIID,amount,pin);
    }
}
