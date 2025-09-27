public class InvoiceGenerationService implements OrderPlacedSubscriber
{
    @Override
    public void onOrderplaced()
    {
        System.out.println("Generating Invoice");
    }
}
