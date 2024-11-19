import java.util.*;
class AutonomousCar {
    int carId , noOfTestsConducted , noOfTestsPassed;
    String brand, environment;
    public AutonomousCar(int carId , String brand , int noOfTestsConducted , int noOfTestsPassed , String environment ){
        this.carId = carId;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
        
    }
    public int getcarId(){
        return carId;
    }
    public String getbrand(){
        return brand;
    }
    public int getnoOfTestsConducted(){
        return noOfTestsConducted;
    }
    public int getnoOfTestsPassed(){
        return noOfTestsPassed;
    }
    public String getenvironment(){
        return environment;
    }
}

public class IPA13 {
    public static int findTestPassedByEnv(AutonomousCar[] autonomousCars ,String user_environment){
        int count = 0;
        for(int i = 0 ; i<autonomousCars.length ; i++){
            if(autonomousCars[i].getenvironment().equalsIgnoreCase(user_environment)){
                count += autonomousCars[i].getnoOfTestsPassed();
            }
        }
        return count;
    }
    public static HashMap<AutonomousCar,String> updateCarGrade(AutonomousCar[] autonomousCars , String user_brand){
        HashMap<AutonomousCar , String> hashMap = new HashMap<AutonomousCar,String>();
        for(int i = 0 ; i<autonomousCars.length ; i++){
            if(autonomousCars[i].getbrand().equalsIgnoreCase(user_brand)){
                int rating = autonomousCars[i].getnoOfTestsPassed() * 100 / autonomousCars[i].getnoOfTestsConducted();
                if(rating >= 80){
                    hashMap.put(autonomousCars[i], "A1");
                }
                else{
                    hashMap.put(autonomousCars[i], "B2");
                }
            }
        }
        if(hashMap.isEmpty()){
            return null;
        }
        return hashMap;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       
        int arr_length = sc.nextInt();sc.nextLine();
        AutonomousCar[] autonomousCars = new AutonomousCar[arr_length];
        for(int i = 0 ; i<arr_length ; i++){
            int carId = sc.nextInt();sc.nextLine();
            String brand = sc.nextLine();
            int noOfTestsConducted = sc.nextInt();sc.ioException();
            int noOfTestsPassed = sc.nextInt();sc.nextLine();
            String environment = sc.nextLine();
            autonomousCars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
        }
        String user_environment = sc.nextLine();
        String user_brand = sc.nextLine();
        int fun1 = findTestPassedByEnv(autonomousCars , user_environment);
        if(fun1 == 0){
            System.out.println("There are no tests passed in this particular environment");
        }
        else{
            System.out.println(fun1);
        }
        HashMap<AutonomousCar , String> fun2 = updateCarGrade(autonomousCars , user_brand);
        if(fun2 == null){
            System.out.println("No car is available with the specified brand");
        }
        else{
            fun2.forEach((k,v) -> System.out.println(k.brand + "::" + v));
        }
        sc.close();
         
    }
}

