// package IPA;
import java.util.*;
class Employee {
    private int employeeId;
    private String name , branch;
    private double rating ;
    private boolean company;
    public Employee(int employeeId , String name , String branch , double rating, boolean company){
        this.employeeId = employeeId;
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.company = company;
    }
    public int getemployeeId(){
        return employeeId;
    }
    public String getname(){
        return name;
    }
    public String getbranch(){
        return branch;
    }
    public double getrating(){
        return rating;
    }
    public boolean getcompany(){
        return company;
    }
}
class MyClass {
    public static int findCountOfEmployeesUsingCompTransport(Employee[] employees, String desire_String){
        int count = 0;
        for(int i = 0;i<employees.length ; i++){
            if(employees[i].getbranch().equalsIgnoreCase(desire_String) && employees[i].getcompany()){
                count++;
            }
        }
        if(count>0){
            return count;
        }
        return 0;
    }
    public static Employee findEmployeeWithSecondHighestRating(Employee[] employees){
        double first_rating = Double.MIN_VALUE;
        double second_rating = Double.MIN_VALUE;
        Employee e ;
        for(int i = 0 ; i<employees.length ; i++){
            if(!employees[i].getcompany() && employees[i].getrating() > first_rating){
                second_rating = first_rating;
                first_rating = employees[i].getrating();
            }
            else if(!employees[i].getcompany() && employees[i].getrating() > second_rating){
                second_rating = employees[i].getrating();
            }
        }
        for(int i = 0 ; i<employees.length ; i++){
            if(employees[i].getrating() == second_rating){
                return employees[i];
            }
        }
        return null;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr_length = sc.nextInt();sc.nextLine();
        Employee[] employees = new Employee[arr_length];
        for(int i= 0;i<arr_length ; i++){
            int employeeId = sc.nextInt();sc.nextLine();
            String name = sc.nextLine();
            String branch = sc.nextLine();
            double rating = sc.nextDouble();sc.nextLine();
            boolean company = sc.nextBoolean();
            employees[i] = new Employee(employeeId, name, branch, rating, company);
        }
        System.out.println("out of the input");
        String desire_branch = sc.nextLine();
        sc.close();
        int number_of_employee = findCountOfEmployeesUsingCompTransport(employees,desire_branch);
        if(number_of_employee == 0){
            System.out.println("No such Employees");
        }
        else {
            System.out.println(number_of_employee);
        }
        Employee employees2 = findEmployeeWithSecondHighestRating(employees);
        if(employees2 == null){
            System.out.println("All Employees using compnay transport");
        }
        else{
            System.out.println(employees2.getemployeeId());
            System.out.println(employees2.getname());
        }
    }
    
}

