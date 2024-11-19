
// import java.util.Scanner;
// import package1.Parent;
// import package1.prothom.Add;

// public class Practice extends Example1 {
//     public Practice(int a1,int a2){
//         super(a1, a2);
//     }
//     public static void main(String[] args) {
//         Practice e1 = new Practice(2, 3);
//         System.out.println(e1.multi());
//     }
// }

import java.util.Scanner;
import java.util.Arrays;
class HeadSets{
    private String headsetName , brand;
    private int price ; 
    private boolean available;
    public HeadSets(String headsetName ,String brand ,int price ,boolean available){
        this.headsetName = headsetName;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
    public String getheadsetsbrand(){
        return brand;
    }
    public int getheadsetsprice(){
        return price;
    }
    public boolean getheadsetsavailable(){
        return available;
    }
    public String getHeadsetsname(){
        return headsetName;
    }
}
class Solution{
    public static int findTotalPriceForGivenBrand(HeadSets[] h , String brand_name){
        int totalprice = 0;
        for(int i = 0 ; i<h.length ; i++){
            if(h[i].getheadsetsbrand().equalsIgnoreCase(brand_name)){
                totalprice += h[i].getheadsetsprice();
            }
        }
        return totalprice;
    }
    public static HeadSets findAvailableHeadsetWithSecondMinPrice(HeadSets[] h){
        int[] arr = new int[h.length];
        int count = 0;
        for(int i = 0 ; i<h.length ; i++){
            if(h[i].getheadsetsavailable()){
                arr[i] = h[i].getheadsetsprice();
                count++;
            }
        }
        if(count < 2){
            return null;
        }
        int finalarray[] = Arrays.copyOfRange(arr , 0 , count);
        Arrays.sort(finalarray);
        int second_min_price = finalarray[1];
        for(int i = 0 ; i<h.length ; i++){
            if(h[i].getheadsetsprice() == second_min_price){
                   return h[i];
            }
        }
        return null;
    }
    public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int arr_length = sc.nextInt();
      sc.nextLine();
      HeadSets[] h = new HeadSets[arr_length];
      for(int i = 0 ; i < arr_length ; i++){
        String headsetName = sc.nextLine();
        String brand = sc.nextLine();
        int price = sc.nextInt();
        boolean available = sc.nextBoolean();
        sc.nextLine();
        h[i] = new HeadSets(headsetName , brand , price , available);
      }
      String brand_name = sc.nextLine();
      sc.close();
      int totalheadsets_price = findTotalPriceForGivenBrand(h,brand_name);
      if(totalheadsets_price > 0){
        System.err.println(totalheadsets_price);
      }
      else{
        System.out.println("No Headsets available with the given brand");
      }
      HeadSets second_minprice = findAvailableHeadsetWithSecondMinPrice(h);
      if(second_minprice == null){
        System.out.println("No Headsets available");
        
      }
      else{
        System.out.println(second_minprice.getHeadsetsname());
        System.out.println(second_minprice.getheadsetsprice());
      }
    }
   
}