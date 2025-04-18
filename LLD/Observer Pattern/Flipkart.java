import java.util.ArrayList;
import java.util.List;

public class Flipkart
{
    List<OrderPlacedSubscriber> subscribers;//=new ArrayList<>();

    public Flipkart()
    {
        subscribers=new ArrayList<>();
    }
    void registerSubscriber(OrderPlacedSubscriber subscriber)
    {
        subscribers.add(subscriber);
    }
    void unregisterSubscriber(OrderPlacedSubscriber subscriber)
    {
        subscribers.remove(subscriber);
    }
    public void orderPlaced()
    {
        for(OrderPlacedSubscriber subscriber:subscribers)
        {
            subscriber.onOrderplaced();
        }
    }
}
