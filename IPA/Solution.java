package IPA;
import java.util.Scanner;
import java.util.Arrays;
class Employee {
     private int employeeId , age;
     private String employeeName;
     private char gender;
     private double salary;
     public Employee(int employeeId , String employeeName , int age , char gender , double salary){
        this.employeeId = employeeId ;
        this.employeeName = employeeName;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
     }

     public int getEmployeeEmployeeId(){
        return employeeId;
     }
     public void setEmployeeEmployeeId(int employeeId){
        employeeId = employeeId;
     }


     public String getEmployeeEmployeeName(){
        return employeeName;
     }
     public void setEmployeeEmployeeName(String employeeName){
        employeeName = employeeName;
     }


     public int getEmployeeage(){
        return age;
     }
     public void setEmployeeage(int age){
        age = age;
     }
     
     
     public char getEmployeegender(){
        return gender;
     }
     public void setEmployeeEmployeegender(char gender){
        gender = gender;
     }
     
     
     public double getEmployeesalary(){
        return salary;
     }
     public void setEmployeeEmployeesalary(double salary){
        salary = salary;
     }
}

/**
 * Solution
 */
class Solution {
    public static Employee getEmployeeWithSecondLowestSalary(Employee[] Employee){
        double[] arr_age = new double[Employee.length];
        for (int i = 0 ; i<Employee.length ; i++){
            arr_age[i] = Employee[i].getEmployeesalary(); 
        }
        if(arr_age.length < 2){
            return null;
        }
        Arrays.sort(arr_age);
        double target_age = arr_age[1];
        for(int i = 0 ; i<Employee.length ; i++){
            if(target_age == Employee[i].getEmployeesalary()){
                return Employee[i];
            }
        }
        return null;
    }
    public static int countEmployeesBasedOnAge(Employee[] Employee , int given_age){
        int count = 0;
        for(int i = 0 ; i <Employee.length ; i++){
            if(Employee[i].getEmployeeage() == given_age){
                count += 1;
            }
        }
        return count;
    }
    public static void main(String args[]){
       Scanner sc = new Scanner(System.in);
       int arr_length = sc.nextInt();
       sc.nextLine();
       Employee[] emp = new Employee[arr_length];
       for(int i = 0; i<emp.length ; i++){
        int employeeId = sc.nextInt();
        sc.nextLine();
        String employeeName = sc.nextLine();
        int age = sc.nextInt();
        char gender = sc.next().charAt(0); // char_input
        double salary = sc.nextDouble();
        sc.nextLine();
        emp[i] = new Employee(employeeId, employeeName, age, gender, salary);
       }
      
       int given_age = sc.nextInt();

       Employee Second_lowest_salary = getEmployeeWithSecondLowestSalary(emp);
       if(Second_lowest_salary == null){
        System.out.println( "Null");
       }
       else{
        int empId = Second_lowest_salary.getEmployeeEmployeeId();
        String empName = Second_lowest_salary.getEmployeeEmployeeName();
        String result = String.format("%d#%s" , empId,empName);
        System.out.println(result);
       }


       int countemp = countEmployeesBasedOnAge(emp,given_age);
       if(countemp > 0){
        System.out.println(countemp);
       }
       else{
        System.out.println("No employee found for the given age");
       }
       sc.close();
    }
     
}