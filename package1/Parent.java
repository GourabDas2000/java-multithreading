package package1;
import package1.prothom.*;
public class Parent {
    public int minustwo(int a , int b){
        int c = (a>b)? (a-b):(b-a);
        return c;
    }
    public static void main(String[] args) {
        Add a1 = new Add();
        int temp = a1.Addtwo(2,3);
        System.out.println(temp);
    }
}
