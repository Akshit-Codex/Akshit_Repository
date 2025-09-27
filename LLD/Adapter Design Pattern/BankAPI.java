public interface BankAPI
{
    double checkBalance(String UPIID,int pin);
    void addNewBankAccount(String bankAccountNumber,
                           String debitCardNumber,
                           int pin,
                           int otp);
    int makePayment(String fromUPIID,String toUPIID,double amount,int pin);
}
