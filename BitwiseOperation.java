public class BitwiseOperation {
      public void leftshift(){
        int temp = 55;
        String Beforeconvert = Integer.toBinaryString(temp);
        System.out.println(Beforeconvert + ":" + temp);
        temp = temp << 2;
        String Afterconvert = Integer.toBinaryString(temp);
        System.out.println(Afterconvert + ":" + temp);
      }

      public void rightshift(){
        int temp = 27;
        String Beforeconvert = Integer.toBinaryString(temp);
        System.out.println(Beforeconvert + ":" + temp);
        temp = temp >> 1;
        String Afterconvert = Integer.toBinaryString(temp);
        System.out.println(Afterconvert + ":" + temp);
      }

      public static void main(String[] args) {
        BitwiseOperation bo = new BitwiseOperation();
        bo.leftshift();
      }
}