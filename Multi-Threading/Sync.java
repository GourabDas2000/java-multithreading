public class Sync extends Thread {
        public counter count ;
        public Sync(counter counter){
            this.count = counter;
        }
        public void run(){
            // count.increment();
            count.sync_increment();
            System.out.println(count.getcount());
        }
    public static void main(String[] args) throws InterruptedException {
        counter count = new counter();
        Sync s1 = new Sync(count);
        Sync s2 = new Sync(count);
        s1.start();
        s2.start();
        
    }
}
