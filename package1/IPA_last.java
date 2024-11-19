package package1;
import java.util.*;
class pro{
    private int id , price , rating;
    private String name , available;
    public pro(int a , String b , int c , int d , String e){
        this.id = a ;
        this.name = b;
        this.price = c;
        this.rating = d;
        this.available = e;
    }
    public int getid(){
        return id;
    }
    public int getrating(){ return rating; }
    public int getprice(){ return price ;}
    public String getavailable(){ return available ;}
}

public class IPA_last {
    public static pro fun1(pro[] pros , int v1){
        int m = Integer.MIN_VALUE;
        String v2 = "TataCliq";
        for(int i = 0;i<pros.length ; i++){
           if(pros[i].getavailable().equalsIgnoreCase(v2) && pros[i].getrating() > v1 && pros[i].getprice() > m){
             m = pros[i].getprice();
           }
        }
        // System.out.println(m);
        for(int i = 0 ;i< pros.length ; i++){
            if(pros[i].getavailable().equalsIgnoreCase(v2) && pros[i].getprice() == m){
                return pros[i];
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        pro[] pros = new pro[4];
        for(int i= 0; i<4 ; i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            String e = sc.nextLine();
            pros[i] = new pro(a, b, c, d, e) ;
        }
        int v1 = sc.nextInt();
        pro r1 = fun1(pros,v1);
        if(r1 == null){
            System.out.println("No such Projector");
        }
        else{
            System.out.println(r1.getid());
        }



        // int a = sc.nextInt();
        // int count = 0;
        // while(a>0){
        //     int r = a%10;
        //     a = a/10;
        //     if(r%2 != 0){
        //         count++;
        //     }
        // }
            
        // if(count>=3){
        //     System.out.println("TRUE");
        // }else{
        //     System.out.println("FALSE");
        // }
        sc.close();
    }
}