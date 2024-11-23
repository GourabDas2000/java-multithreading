public class counter{
    public int count = 0;
    public void increment(){
        for(int i= 0 ;i<10000;i++){
            count++;
        }
    }
    public synchronized void sync_increment(){
        System.out.println(Thread.currentThread().getName());
        for(int i= 0 ;i<10000;i++){
            count++;
        }
    }
    public int getcount(){
        return count;
    }
}
