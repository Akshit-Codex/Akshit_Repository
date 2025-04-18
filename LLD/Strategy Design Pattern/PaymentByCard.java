public class PaymentByCard implements PaymentStrategy
{
    private DebitCard card;

    @Override
    public void collectPaymentDetails()
    {
        card=new DebitCard("cardNumber","CVV","Expiry");
        System.out.println("Details collected");
    }

    @Override
    public boolean validatePaymentDetails()
    {

        return true;
    }

    @Override
    public void Pay()
    {

    }
}
