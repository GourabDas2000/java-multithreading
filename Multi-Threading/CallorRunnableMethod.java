import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallorRunnableMethod {
    public static void main(String[] args) {
        ExecutorService execute = Executors.newCachedThreadPool();
        Future<?> future = execute.submit(() -> { System.out.println("42"); }); // This is callable method
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(future.isDone());

        Callable<Integer> c = new Callable<Integer>() {
            public Integer call(){
                return 1;
            }
        };

        try {
            System.out.println("This is from calleble block");
            int  a = c.call();
            System.out.println(a);
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }


        ExecutorService exserv = Executors.newFixedThreadPool(4);


        System.out.println("Now it is a runnable method");
        exserv.submit(() ->  42 ); // This is a runnable method
    }
}
