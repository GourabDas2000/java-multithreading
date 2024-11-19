package IPA;

public class SecondMostel {
    public static void main(String[] args) {
        int[] a = {13,2,5,1,4,6};
        int frist_value = Integer.MIN_VALUE;
        int second_value = Integer.MIN_VALUE;
        for(int i = 0; i<a.length ; i++){
            if(a[i] > frist_value){
                second_value = frist_value;
                frist_value = a[i];
            }
            else if(a[i] > second_value && a[i]<frist_value){
                second_value = a[i];
            }
        }
        System.out.println(second_value);
    }
}
