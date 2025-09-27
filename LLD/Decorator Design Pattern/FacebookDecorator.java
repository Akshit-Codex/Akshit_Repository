public class FacebookDecorator extends BaseDecorator
{
    public FacebookDecorator(INotify wrapped)
    {
        //this.userName=userName;
        super(wrapped);
    }

    public void sendMsg(String msg)
    {
        super.sendMsg(msg);
        String FB=databaseService.getFBNamefromUsername(getUserName());
        System.out.println("Sending "+getUserName()+"msg to "+FB);
    }
}
//https://github.com/geekific-official/geekific-youtube/blob/main/design-patterns/
// structural-decorator/src/main/java/com/youtube/geekific/FacebookDecorator.java