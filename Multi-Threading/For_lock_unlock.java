public class For_lock_unlock extends Thread {
    private Lock_Unlock lc ;
    public For_lock_unlock(Lock_Unlock lc , String name){
        this.lc = lc;
        super(name);
    }
    public void run(){
        lc.withdraw(50);
    }
    public static void main(String[] args) {
        Lock_Unlock lu1 = new Lock_Unlock();
        For_lock_unlock t1 = new For_lock_unlock(lu1, "First");
        For_lock_unlock t2 = new For_lock_unlock(lu1, "Second");
        t1.start();
        t2.start();
    
    }
}
