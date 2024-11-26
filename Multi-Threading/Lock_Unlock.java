import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_Unlock{
    private int balance = 100;

    private final Lock lock = new ReentrantLock();
    public  void withdraw(int value){
        if(value > balance){
            System.out.println("Insufficient Balance");  
        }
        else if (value>0 && value<=100) {
            try{
                // lock.tryLock(); //works like normal without mentioning any time
                // lock.lock();// it works like synchronized keyword
                // System.out.println("Thread name is :" + Thread.currentThread().getName());
                if(lock.tryLock(200 , TimeUnit.MILLISECONDS)){
                    try{
                        System.out.println("Lock accuried by - " + Thread.currentThread().getName());
                        Thread.sleep(3000); //It will be waiting till t1 finished then t2 will start ... if in between anything happen then it will create a problem
                        balance = balance - value;
                    }catch(Exception e){
                        Thread.currentThread().interrupt();
                    }finally{
                        lock.unlock();
                        System.out.println(value + "Rs./ is withdrawn " + " and Exit of Thread - " + Thread.currentThread().getName());
                    }
                }
                else{
                    System.out.println("Lock accuired by another thread");
                }
            }catch(Exception e){
                Thread.currentThread().interrupt();
            }
        }
        else{
            System.out.println("Enter the valid details or try again later");
        }
        System.out.println("Remaining Balance is - " + balance);
    }
}