public class Notify implements INotify
{
    private String userName;
    private DatabaseService databaseService;

    public Notify(String userName)
    {
        this.userName=userName;
        this.databaseService=new DatabaseService();
    }

    @Override
    public void sendMsg(String message)
    {
        String mail=databaseService.getMailfromUsername(userName);
        System.out.println("Sending"+message+" by mail to "+mail);
    }

    @Override
    public String getUserName()
    {
        return userName;
    }
}
