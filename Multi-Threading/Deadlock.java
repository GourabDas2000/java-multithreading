import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Deadlock {
    private final Lock lock = new ReentrantLock(true);//fairness
    public void outervoid(){
        try{
            lock.lock();
            // lock.lockInterruptibly();//blocked state if anothere thread inturupted it
            // System.out.println(Thread.currentThread().getState());
            innermethod();
            System.out.println("outere method");
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
        }
    }
    public void innermethod(){
        try{
            lock.lock();
            System.out.println("inner method");
            // outervoid();
        }catch(Exception e){
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        Deadlock deadlock = new Deadlock();
        deadlock.outervoid();
    }
}
