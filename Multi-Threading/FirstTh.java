import java.util.*;


public class FirstTh extends Thread{

    public void run(){
        for(int i = 0;i<=1000;i++){
            System.out.println("world - th");
        }
    }
}