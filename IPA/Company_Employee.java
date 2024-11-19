package IPA;
import java.util.*;;
/**
 * Company_Employee
 */
class Employee{
    private int id ; double salary;
    private String name , designation;
    public Employee(int id , String name , String desgination , double salary){
        this.id = id ;
        this.name = name;
        this.designation = desgination;
        this.salary = salary;
    }
    public String getname(){
        return name;
    }
    public int getid(){
        return id;
    }
    public double getSalary(){
        return salary;
    }
    public String getDesignation(){
        return designation;
    }
}

class Company{
    private String companyName;
    Employee[] employees;
    private int numEmployees ;
    public Company(String compnayName , Employee[] employees , int numEmployees){
        this.companyName = compnayName;
        this.employees = employees;
        this.numEmployees = numEmployees;
    }
    public double getAverageSalary(){
        double averageSalary = 0;
        for(int i = 0; i<employees.length;i++){
            averageSalary += employees[i].getSalary();
        }
        return averageSalary/numEmployees;
    }
    public double getMaxSalary(){
        double maxsalary = Integer.MIN_VALUE;
        for(int i = 0 ; i<employees.length;i++){
            if(maxsalary < employees[i].getSalary()){
                maxsalary = employees[i].getSalary();
            }
        }
        return maxsalary;
    }
    public List<Employee> getEmployeesDesignation(String desig){
        List<Employee> l = new ArrayList<>();
        for(int i = 0 ; i<employees.length; i++){
            if(employees[i].getDesignation().equalsIgnoreCase(desig)){
                l.add(employees[i]);
            }
        }
        return l;

    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter compnay name :");
        String companyName = sc.nextLine();
        System.out.print("Enter number of employee :");
        int no_of_employee = sc.nextInt();sc.nextLine();
        Employee[] employees = new Employee[no_of_employee];
        for(int i = 0 ;i < no_of_employee ; i++){
            System.out.print("Enter employee details :");
            System.out.println("Employee" + " " + (i+1) );
            System.out.print("Enter id: ");
            int id = sc.nextInt();sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter designation: ");
            String desgination = sc.nextLine();
            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();sc.nextLine();
            employees[i] = new Employee(id, name, desgination, salary);
        }
        Company company = new Company(companyName, employees, no_of_employee);
        double averageSalary = company.getAverageSalary();
        System.out.println("Average salary :" + averageSalary);
        double salary = company.getMaxSalary();
        System.out.println("Max salary:" + salary);
        System.out.print("Employees with designation: ");
        String desig = sc.nextLine();
        List<Employee> l = company.getEmployeesDesignation(desig);
        for(int i = 0; i<l.size(); i++){
            System.out.println("ID:"+ l.get(i).getid() + ", Name: " + l.get(i).getname() + ", Designation: "+l.get(i).getDesignation() + ", Salary :" + l.get(i).getSalary() );
        }
        sc.close();
    }

}