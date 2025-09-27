public class NumberThread implements Runnable
{
    private int number;
    NumberThread(int number)
    {
        this.number=number;
    }
    @Override
    public void run()
    {
        System.out.println("The numbers are: "+ number);
    }
    public static void main(String ...s)
    {
        for(int i=1;i<=10;i++)
        {
            Thread t = new Thread(new NumberThread(i));
            t.start();
        }
    }
}
