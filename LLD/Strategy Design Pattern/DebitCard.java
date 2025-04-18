public class DebitCard
{

    private int amount=1000;

    private String cardNumber = "1234";
    private String cvv="777";
    private String expiry= "2027";
    public DebitCard(String cardNumber,String cvv,String expiry)
    {
        this.cardNumber=cardNumber;
        this.cvv=cvv;
        this.expiry=expiry;
    }
}
