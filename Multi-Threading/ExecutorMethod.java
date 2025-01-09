import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorMethod {
    public static void main(String[] args) throws ExecutionException, TimeoutException {
        int res = 0;
        Callable<Integer> c1 = (() -> {
            System.out.println("In Thread1 - " + Thread.currentThread().getName());
            try{
                Thread.yield();
                Thread.sleep(2000);
            }catch(Exception e){

            }finally{
                System.out.println("out of Thread1");
            }
            return 1;});
        Callable<Integer> c2 = (() -> {
            System.out.println("In Thread2 - " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                Thread.yield();
            } catch (Exception e) {

            }finally{
                System.out.println("out of Thread2");
            }
            
            return 2;});
        Callable<Integer> c3 = (() -> {
            System.out.println("In Thread3 - " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
                Thread.yield();
            } catch (Exception e) {

            }finally{
                System.out.println(
                    "out of Thread3");
            }
            return 3;});

        List<Callable<Integer>> calllist = Arrays.asList(c1,c2,c3);
        ExecutorService exserv = Executors.newFixedThreadPool(3 );
        List<Future<Integer>> executelist = null;
        try {
            // executelist = exserv.invokeAll(calllist); 
            res = exserv.invokeAny(calllist,1000,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        exserv.shutdown();
        
        if (executelist != null) {
            for (Future<Integer> el : executelist) {
                try {
                    System.out.println(el.get()); // Retrieve and print the result
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task interrupted");
                } catch (ExecutionException e) {
                    System.out.println("Error in task execution: " + e.getMessage());
                }
            }
        }
        try {
            System.out.println(res);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
