public class WareHouseMgtService implements OrderPlacedSubscriber
{
    @Override
    public void onOrderplaced() {
        System.out.println("WareHouse is informed");
    }
}
