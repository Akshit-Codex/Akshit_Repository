public class Client
{
    public static void main(String[] args)
    {
        Flipkart flipkart=new Flipkart();
        flipkart.registerSubscriber(new InvoiceGenerationService());
        flipkart.orderPlaced();
    }
}
