import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main
{
    public static void main(String ...s) throws Exception
    {
        List<Integer> arrayList=List.of(2,3,7,1,5,9);
        ExecutorService executorService= Executors.newCachedThreadPool();
        Sorter sample=new Sorter(arrayList,executorService);

        Future<List<Integer>> futureArray=executorService.submit(sample);
        System.out.println(futureArray.get());
        executorService.shutdown();
    }
}
