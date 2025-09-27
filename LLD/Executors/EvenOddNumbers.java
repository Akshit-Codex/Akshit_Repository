import javax.naming.InvalidNameException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenOddNumbers implements Runnable
{
    private int number;
    EvenOddNumbers(int number)
    {
        this.number=number;
    }
    @Override
    public void run()
    {
        System.out.println("Even nos. are: "+number);
    }
    public static void main(String ...s) throws Custom_Exception
    {
        int[] a={1,5,4,6};
        ExecutorService executorService= Executors.newCachedThreadPool();
        for(int i=0;i<a.length;i++)
        {
            try
            {
                validate(executorService,a[i]);
            }
            catch(Exception e)
            {
                //System.out.println(e.getMessage());
                throw new Custom_Exception("JUST SEE IF THIS HITS AND "+e.getMessage());
            }
        }
        executorService.shutdown();
    }
    static void validate(ExecutorService executorService,int number) throws Custom_Exception
    {
        if(number%2!=0)
        {
            throw new Custom_Exception("Numbers cant be odd");
        }
        else
        {
            executorService.execute(new EvenOddNumbers(number));
        }
    }
}
class Custom_Exception extends Exception
{
    public Custom_Exception(String error)
    {
        super(error);
    }
}