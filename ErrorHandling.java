import java.util.Scanner;;
public class ErrorHandling implements interface1 {
    public void display(){
        System.out.println("This is a interface method");
    }
    public int makedress(){
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();
        sc.close();
        if(age == 0){
            throw new ArithmeticException("Age cannot be zero");
        }
        return age;
    }
    public boolean ispermit(int age){
        try{
            int p = 100/age;
            System.err.println(p);
        }
        catch(ArithmeticException e){
            e.printStackTrace();
            System.err.println("ok");
            System.err.println( e.fillInStackTrace());
            e.getMessage();
            return false;
        }
        if(age < 18){
            throw new ArithmeticException("Age is too low");
        }
        return true;
    }
    public static void main(String[] args) {
        ErrorHandling e = new ErrorHandling();
        System.out.println(e.makedress());
    }
}
