public class Main
{
    public static void main(String[] args)
    {
        //PhonePe phonePe=new PhonePe(new AxisBankAPIAdapter());
        PhonePe phonePe=new PhonePe(new YesBankAPIAdapter());

        phonePe.paymentResults("Akshit","Marut",1000,123);
    }
}
