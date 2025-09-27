//import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberSystem implements Runnable
{
    private int number;
    NumberSystem(int number)
    {
        this.number=number;
    }
    @Override
    public void run()
    {
        System.out.println("Numbers are: "+number);
    }
    public static void main(String ...s)
    {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++)
        {
            executorService.execute(new NumberSystem(i));
        }
        executorService.shutdown();
    }
}
