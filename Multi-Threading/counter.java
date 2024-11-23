public class counter extends Thread {
    public int count = 0;
    public void increment(){
        for(int i= 0 ;i<10000;i++){
            count++;
        }
    }
    public synchronized void sync_increment(){
        for(int i= 0 ;i<10000;i++){
            count++;
        }
    }
    public int getcount(){
        return count;
    }
}
