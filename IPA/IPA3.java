package IPA;
import java.util.*;
class Student{
	private int rollNo;
	private String name ;
	private String branch;
	private double score;
	private boolean dayScholoar;
	public Student(int rollNo , String name, String branch , double score , boolean dayScholoar){
		this.rollNo = rollNo;
		this.name = name ;
		this.branch = branch;
		this.score = score;
		this.dayScholoar = dayScholoar;
	}
	public int getrollNo(){
		return rollNo;
	}
	public String getname(){
		return name;
	}
	public String getbranch(){
		return branch;
	}
	public double getscore(){
		return score;
	}
	public boolean getdayScholoar(){
		return dayScholoar;
	}
}
	
public class IPA3 {
	public static int findCountOfDayscholarStudents(Student[] students){
		int count = 0 ; 
		for(int i = 0 ; i<students.length; i++){
			if(students[i].getscore() > 80 && students[i].getdayScholoar()){
				count++;
			}
		}
		return count;
	}
	public static Student findStudentwithsecondHIghestScore(Student[] students){
		Student result = null;
		double highest_score = Double.MIN_VALUE;
		double second_score = Double.MIN_VALUE;
		for(int i = 0 ; i<students.length ; i++){
			if(students[i].getscore() > highest_score && !students[i].getdayScholoar()){
				second_score = highest_score;
				highest_score = students[i].getscore();
			}
			else if(second_score < students[i].getscore() && !students[i].getdayScholoar()){
				second_score = students[i].getscore();
			}
		}
		
		for(int i = 0 ; i <students.length; i++){
			if(students[i].getscore() == second_score && !students[i].getdayScholoar()){
				return students[i];
			}
		}
		return null;	
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		Student[] students = new Student[4];
		for(int i=0; i<4 ;i++){
			int rollNo = sc.nextInt();sc.nextLine();
			String name = sc.nextLine();
			String branch = sc.nextLine();
			double score = sc.nextDouble();sc.nextLine();
			boolean dayScholoar = sc.nextBoolean();
			students[i] = new Student(rollNo , name , branch , score , dayScholoar);
		}
		sc.close();
		int fun1 = findCountOfDayscholarStudents(students);
		if(fun1 == 0){
			System.out.println("There are no such dayscholar students");
		}
		else{
			System.out.println(fun1);
		}
		Student fun2 = findStudentwithsecondHIghestScore(students);
		if(fun2 == null){
			System.out.println("There are no student from non day scholar");
		}
		else{
			System.out.println(fun2.getrollNo() + "#" + fun2.getname() + "#" + fun2.getscore());
		}
	}
    
}
