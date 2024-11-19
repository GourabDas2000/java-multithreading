public class LifeCycleThread extends Thread {
    public LifeCycleThread(String name){ super(name);}
    public void run(){
        for(int i = 0 ; i<3 ; i++){
            try{
                LifeCycleThread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            System.out.println(i);
        }
        System.out.println("Thread Name - " + Thread.currentThread().getName());
    }
    public static void main(String[] args) throws InterruptedException {
        LifeCycleThread lc = new LifeCycleThread("Gourab");
        System.out.println(lc.getState());//new
        lc.start();
        System.out.println(lc.getState());// runnable
        lc.sleep(100);
        System.out.println(lc.getState());//Timed waiting
        lc.interrupt();//blocked
        System.out.println(lc.getState());
        lc.join();
        System.out.println(lc.getState());//Terminated
    }
}
