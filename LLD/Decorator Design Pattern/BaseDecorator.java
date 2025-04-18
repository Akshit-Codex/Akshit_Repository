public abstract class BaseDecorator implements INotify
{
    protected DatabaseService databaseService;
    private INotify wrapped;

    public BaseDecorator(INotify wrapped)
    {
        this.wrapped=wrapped;
        this.databaseService=new DatabaseService();
    }
    public void sendMsg(String msg)
    {
        wrapped.sendMsg(msg);
    }
    public String getUserName()
    {
        return wrapped.getUserName();
    }

}
