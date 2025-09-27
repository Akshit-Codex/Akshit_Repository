public class Main
{
    public static void main(String[] args)
    {
        INotify notify=new FacebookDecorator(new Notify("GEEKIFY"));
        notify.sendMsg("Like share subscribe");
    }
}
// THIS DESIGN PATTERN FEELS LIKE OBSERVER DESIGN PATTERN BUT THIS WORKS DYNAMICALLY