import java.security.Timestamp;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorFrameworks {
    public void factorial(int data){
        int count = 1;
        for(int i = 1 ; i <= data ; i++){
            count *= i;
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        
        // Before Executor Framework Introduction
        // long starttime = System.currentTimeMillis();
        // Thread[] threads = new Thread[9];
        // ExecutorFrameworks exfame = new ExecutorFrameworks();
        // for(int i = 1 ; i<10 ;i++){
        //     final int res = i; //have to declear final beacause it is a local variable  and changing
        //     threads[i-1] = new Thread(){
        //         public void run(){
        //             try{
        //                 Thread.sleep(1000);
        //             }catch(InterruptedException e){
        //                 Thread.currentThread().interrupt();
        //             }
        //             exfame.factorial(res);
        //         }
        //     };
        //     threads[i-1].start();
        // }
        // for(Thread thread:threads){
        //     try{
        //         thread.join();
        //     }catch (InterruptedException e) {
        //         Thread.currentThread().interrupt();
        //     }
        // }
        // long result =  starttime - System.currentTimeMillis();
        // System.out.println("Execution time " + result);
        

        // With Executor Framework
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // ExecutorService executor = Executors.newCachedThreadPool();
        for(int i = 1 ; i<=9 ;i++ ){
            int finali = i;
            ExecutorFrameworks exf = new ExecutorFrameworks();
            executor.submit(() -> {
                    try{
                        Thread.sleep(1000);
                        exf.factorial(finali);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
            });
        }
        
        executor.shutdown(); 

        // executor.shutdownNow();

        try {
            while(!executor.awaitTermination(2000, TimeUnit.MILLISECONDS)){
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        while(!executor.isTerminated()){ // wait until it terminates
        }


        long result = System.currentTimeMillis() - start;
        System.out.println("Time : " + result);
        


    }
}