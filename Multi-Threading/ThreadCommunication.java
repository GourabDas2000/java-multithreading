class SharedResource{
    public int count = 0;
    public boolean hasdata;
    
    public synchronized void producedata() {
        
        for(int i = 0 ; i<10 ;i++){
            if (hasdata) {
                try{
                    wait();
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            count = i;
            System.out.println("Produced - " + i);
            hasdata = true;
            notify();
        }
    }
    public synchronized void consumedata(){
        for(int i = 0 ; i<10 ;i++){
            if (!hasdata) {    
                try{
                    wait();
                }catch(InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Consumed - " + count);
            hasdata = false;
            notify();
        }
    }

}


class Produce implements Runnable {
    SharedResource source;

    public Produce(SharedResource resource){
        this.source = resource;
    }
    public void run(){
        source.producedata();
    }
    
}
class Consume implements Runnable {
    SharedResource source ;
    public Consume(SharedResource resource){
        this.source = resource;
    }
    public void run() {
        source.consumedata();
    }
}


public class ThreadCommunication {
    public static void main(String[] args) {
        SharedResource source = new SharedResource();
        Thread t1 = new Thread(new Produce(source));
        Thread t2 = new Thread(new Consume(source));
        
        t1.start();
        t2.start();
    }    
}
