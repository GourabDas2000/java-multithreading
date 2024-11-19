public class ThreadMethods extends Thread {
    public ThreadMethods(String name ){ super(name);}
    public void run(){
        for(int i = 0 ; i<4;i++){
            System.out.println(Thread.currentThread().getName() + " - " + i);
            ThreadMethods.yield();//switch to another thread
        }
    }
    public static void main(String[] args) {
        ThreadMethods t1 = new ThreadMethods( "High");
        ThreadMethods t2 = new ThreadMethods("Medium");
        ThreadMethods t3 = new ThreadMethods("Low");
        t1.setPriority(MAX_PRIORITY);
        t2.setPriority(5);
        t3.setPriority(MIN_PRIORITY);
        t1.start();
        t2.start();
        t3.setDaemon(true);//make background thread
        t3.start();
    }
}