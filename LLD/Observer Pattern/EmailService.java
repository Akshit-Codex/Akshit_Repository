public class EmailService implements OrderPlacedSubscriber
{
    @Override
    public void onOrderplaced()
    {
        System.out.println("Sending Email ");
    }
}
