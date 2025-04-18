public interface PaymentStrategy
{
    void collectPaymentDetails();
    boolean validatePaymentDetails();
    void Pay();
}
