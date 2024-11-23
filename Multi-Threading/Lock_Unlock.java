public class Lock_Unlock{
    private int balance = 100;
    public synchronized void withdraw(int value){
        if(value > balance){
            System.out.println("Insufficient Balance");
            
        }
        else if (value>0 && value<=100) {
            try{
                balance = balance - value;
                Thread.sleep(2000);
            }catch(Exception e){
                System.out.println(e);
            }finally{
                System.out.println("Thread name is :" + Thread.currentThread().getName());
                System.out.println(value + "Rs./ is withdrawn ");
            }
        }
        else{
            System.out.println("Enter the valid details or try again later");
        }
        System.out.println("Remaining Balance is - " + balance);
    }
}