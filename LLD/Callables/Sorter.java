import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class Sorter implements Callable<List<Integer>>
{
    private List<Integer> arrayList;
    private ExecutorService executorService;
    Sorter(List<Integer> arrayList,ExecutorService executorService)
    {
        this.arrayList=arrayList;
        this.executorService=executorService;
    }
    public List<Integer> call() throws Exception
    {
        if(arrayList.size()==1)
        {
            return arrayList;
        }
        int n=arrayList.size();
        int mid=n/2;

        List<Integer> leftArray=new ArrayList<>();
        List<Integer> rightArray=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(i<mid)
            {
                leftArray.add(arrayList.get(i));
            }
            else
            {
                rightArray.add(arrayList.get(i));
            }
        }
        Sorter leftSort=new Sorter(leftArray,executorService);
        Sorter rightSort=new Sorter(rightArray,executorService);

        Future<List<Integer>> leftfuture=executorService.submit(leftSort);
        Future<List<Integer>> rightFuture=executorService.submit(rightSort);

        leftArray=leftfuture.get();
        rightArray=rightFuture.get();

        List<Integer> output=new ArrayList<>();
        int i=0,j=0;
        while(i<leftArray.size() && j<rightArray.size())
        {
            if(leftArray.get(i)<rightArray.get(j))
            {
                output.add(leftArray.get(i));
                i++;
            }
            else
            {
                output.add(rightArray.get(j));
                j++;
            }
        }
        while (i<leftArray.size())
        {
            output.add(leftArray.get(i));
            i++;
        }
        while (j<rightArray.size())
        {
            output.add(rightArray.get(j));
            j++;
        }

        return output;
    }
}
