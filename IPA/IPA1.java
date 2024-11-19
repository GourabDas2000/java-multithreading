package IPA;
import java.util.*;
class Course{
    private int courseId;
    private String courseName ;
    private String courseAdmin;
    private int quiz;
    private int handson;
    public Course(int courseId, String courseName , String courseAdmin , int quiz , int handson ){
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseAdmin = courseAdmin;
        this.quiz = quiz;
        this.handson = handson;
    }
    public int getcourseId(){
        return courseId;
    }
    public String getcourseName(){
        return courseName;
    }
    public String getcourseAdmin(){
        return courseAdmin;
    }
    public int getquiz(){
        return quiz;
    }
    public int gethandson(){
        return handson;
    }
}

class courseProgram{
    public static int findAvgOfQuizByAdmin(Course[] courses , String Admin){
        int average =0 ,count = 0 ;
        for(int i = 0 ; i<courses.length ; i++){
            if(courses[i].getcourseAdmin().equalsIgnoreCase(Admin)){
                count++;
                average += courses[i].getquiz();
            }
        }
        if(count == 0){
            return count;
        }
        return average/count;
    }
    public static Course[] sortCourseByHandsOn(Course[] courses, int desire_handsOn){
        int count = 0;
        List<Integer> l = new ArrayList<Integer>();
        for(int i = 0 ;i<courses.length ; i++){
            if(courses[i].gethandson() < desire_handsOn){
                l.add(courses[i].gethandson());
                count++;
            }
        }
        if(count == 0){
            return null;
        }
        l.sort((a,b) -> b-a);
        Course[] des_course = new Course[count];
        int k = 0;
        for(int i= 0 ; i<l.size() ; i++){
            for(int j= 0 ; j<courses.length ; j++){
                if(courses[j].gethandson() == l.get(i)){
                    des_course[k++] = courses[j];
                }
            }
        }
        return des_course;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int arr_length = sc.nextInt();sc.nextLine();
        Course[] courses = new Course[arr_length];
        for(int i = 0; i<arr_length ; i++){
            int courseId = sc.nextInt();sc.nextLine();
            String courseName = sc.nextLine();
            String courseAdmin = sc.nextLine();
            int quiz = sc.nextInt();sc.nextLine();
            int handson = sc.nextInt();sc.nextLine();
            courses[i] = new Course(courseId, courseName, courseAdmin, quiz, handson);
        }
        String Admin = sc.nextLine();
        int desire_handsOn = sc.nextInt();sc.nextLine();
        sc.close();
        int average = findAvgOfQuizByAdmin(courses , Admin);
        if(average == 0){
            System.out.println("No Course found");
        }
        else{
            System.out.println(average);
        }
        Course[] matched_course = sortCourseByHandsOn(courses,desire_handsOn);
        if(matched_course == null){
            System.out.println("No Course found with mentioned attribute");
        }
        else{

            for(int i = 0 ; i<matched_course.length ; i++){
                System.out.println(matched_course[i].getcourseName());
            }
        }
        
    }
}