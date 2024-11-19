package IPA;
import java.util.*;
class MyClass{
    private int engineId;
    private String engineName , engineType ;
    private double enginePrice;
    public MyClass(int engineId , String engineName , String engineType , double enginePrice){
        this.engineId = engineId;
        this.engineName = engineName;
        this.engineType = engineType;
        this.enginePrice = enginePrice;
    }
    public int getengineId(){
        return engineId;
    }
    public String getengineName(){
        return engineName;
    }
    public String getengineType(){
        return engineType;
    }
    public double getenginePrice(){
        return enginePrice;
    }
}
public class IPA20 {
    public static int findAvgEnginePriceByType(MyClass[] myClasses , String var1){
        int average = 0 , count = 0;
        
        for(int i = 0 ; i<myClasses.length ; i++){
            if(myClasses[i].getengineType().equalsIgnoreCase(var1)){
                average += myClasses[i].getenginePrice();
                count++;
            }
        }
        if(count == 0){
            return 0;
        }
        else{
            return average/count;
        }
    }
    public static MyClass[] searchEngineByName(MyClass[] myClasses , String var2){
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0 ; i<myClasses.length ; i++){
            if(myClasses[i].getengineName().equalsIgnoreCase(var2)){
                l.add(myClasses[i].getengineId());
            }
        }
        if(l.isEmpty()){
            return null;
        }
        l.sort((a,b) -> a-b);
        MyClass[] result = new MyClass[l.size()];
        int k = 0;
        for(int i = 0; i<myClasses.length ; i++){
            for(int j = 0 ; j<l.size(); j++){
                if(l.get(j) == myClasses[i].getengineId()){
                    result[k++] = myClasses[i];
                }

            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyClass[] myClasses = new MyClass[4];
        for(int i = 0 ; i <myClasses.length ; i++){
            int engineId = sc.nextInt();sc.nextLine();
            String engineName = sc.nextLine();
            String engineType = sc.nextLine();
            double enginePrice = sc.nextDouble();sc.nextLine();
            myClasses[i]  = new MyClass(engineId, engineName, engineType, enginePrice);
        }
        String var1 = sc.nextLine();
        String var2 = sc.nextLine();
        sc.close();
        int fun1 = findAvgEnginePriceByType(myClasses, var1);
        if(fun1 == 0){
            System.out.println( "There are no engine with given type");
        }
        else{
            System.out.println(fun1);
        }
        MyClass[] result = searchEngineByName(myClasses, var2);
        if(result == null){
            System.out.println("There are no engine with the given name");
        }
        else{
            for(MyClass myClass:result){
                System.out.println(myClass.getengineId());
            }
        }
    }
    
}
