import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public final Lock lock1 = new ReentrantLock();
    public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public final Lock readLock = lock.readLock();
    public final Lock writeLock = lock.writeLock();
    private int count = 0;
    public void readcount(){
        lock.readLock();
        try{
            System.out.println("Entry - " + Thread.currentThread().getName());
            System.out.println(count);
            Thread.sleep(5000);
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
        finally{
            System.out.println("Exit - " + Thread.currentThread().getName());
        }

    }
    public void incrementcount() throws InterruptedException{
        if( lock1.tryLock(1000 , TimeUnit.MILLISECONDS) ){

            lock.writeLock();
            System.out.println("Ready to Entry - " + Thread.currentThread().getName());
            try{
                System.out.println("Entry - " + Thread.currentThread().getName());
                count++;
                Thread.sleep(5000);
            }catch(Exception e){
                Thread.currentThread().interrupt();
            }
            finally {
                System.out.println(count);
                System.out.println("Exit - " + Thread.currentThread().getName());
            }
        }
        else{
            System.out.println("There is anothere thread operating");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Runnable readtask = new Runnable(){
            ReadWriteLockDemo rwd = new ReadWriteLockDemo();
            public void run(){
                rwd.readcount();
            }
        };

        Runnable writetask = new Runnable() {
            ReadWriteLockDemo rwd = new ReadWriteLockDemo();
            public void run(){
                try{

                    rwd.incrementcount();
                }catch(Exception e){
                    Thread.currentThread().interrupt();
                }
                // rwd.readLock();
            }
        };
        // For reading

        // Thread t1 = new Thread(readtask , "read1");
        // Thread t2 = new Thread(readtask, "read2");
        // t1.start();
        // t2.start();

        //For writing

        Thread t1 = new Thread(writetask, "read1");
        Thread t2 = new Thread(writetask, "read2");
        t1.start();
        t2.start();

    }
}