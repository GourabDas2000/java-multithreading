import java.util.concurrent.ExecutorService;

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

        //After Executor Introduction

        // ExecutorFrameworks exfam2 = new ExecutorFrameworks();
        // ExecutorService executor = new ExecutorService() {
            
        // };
        

    }
}