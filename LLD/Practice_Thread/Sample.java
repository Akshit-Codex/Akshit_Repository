public class Sample implements Runnable
{
    @Override
    public void run()
    {
        System.out.println("Running the thread");
    }
    public static void main(String...s)
    {
        Sample ss=new Sample();
        Thread t=new Thread(ss);
        t.start();
    }
}
