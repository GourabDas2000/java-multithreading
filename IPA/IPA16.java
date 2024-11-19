package IPA;
import java.util.*;
class NavalVessel{
    public int vesselId,noOfVoyagesPlanned , noOfvoyagesCompleted;
    public String vesselName, purpose , classification;
    public NavalVessel(int vesselId , String vesselName , int noOfVoyagesPlanned , int noOfvoyagesCompleted , String purpose){
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.noOfVoyagesPlanned = noOfVoyagesPlanned;
        this.noOfvoyagesCompleted = noOfvoyagesCompleted;
        this.purpose = purpose;
    }
    public int getvesselId(){
        return vesselId;
    }
    public String getvesselName(){
        return vesselName;
    }
    public int getnoOfVoyagesPlanned(){
        return noOfVoyagesPlanned;
    }
    public int getnoOfvoagesCompleted(){
        return noOfvoyagesCompleted;
    }
    public String getpurpose(){
        return purpose;
    }
    public void setclassification(String classification){
        this.classification = classification;
    }
    public String getclassification(){
        return classification;
    }
}

public class IPA16 {
    public static int findAvgVoyagesByPct(NavalVessel[] navalVessels , int percentage){
        int total = 0 , count = 0 ;
        for(int i = 0 ; i<navalVessels.length ; i++){
            int testpercentage = navalVessels[i].getnoOfvoagesCompleted() * 100 / navalVessels[i].noOfVoyagesPlanned;
            if(testpercentage >= percentage){
                total += navalVessels[i].getnoOfvoagesCompleted();
                count++;
            }
            
        }
        if(count == 0){
            return 0;  // this condition prevent dividebyzero exception
        }
        return total/count;
    }   

    public static NavalVessel findVesselByGrad(NavalVessel[] navalVessels , String user_purpose){
        for(int i = 0 ; i<navalVessels.length ; i++){
            if(navalVessels[i].getpurpose().equalsIgnoreCase(user_purpose)){
                int testpercentage = navalVessels[i].getnoOfvoagesCompleted() * 100 / navalVessels[i].noOfVoyagesPlanned;
                if(testpercentage == 100){
                    navalVessels[i].setclassification("Star");
                }
                else if(testpercentage < 100 && testpercentage>= 80){
                    navalVessels[i].setclassification("Leader");
                }
                else if(testpercentage <80 && testpercentage >= 55){
                    navalVessels[i].setclassification("Inspirer");
                }
                else{
                    navalVessels[i].setclassification("Striver");
                }
                return navalVessels[i];
            }
        }
        return null;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NavalVessel[] navalVessels = new NavalVessel[4];
        for(int i = 0 ; i<navalVessels.length ; i++){
            int vesselId = sc.nextInt();sc.nextLine();
            String vesselName = sc.nextLine();
            int noOfVoyagesPlanned = sc.nextInt(); sc.nextLine();
            int noOfvoyagesCompleted = sc.nextInt();sc.nextLine();
            String purpose = sc.nextLine();
            navalVessels[i] = new NavalVessel(vesselId, vesselName, noOfVoyagesPlanned, noOfvoyagesCompleted, purpose);
        }
        int percentage = sc.nextInt();sc.nextLine();
        String user_purpose = sc.nextLine();
        sc.close();
        int fun1 = findAvgVoyagesByPct(navalVessels , percentage);
        System.out.println(fun1);

        NavalVessel result = findVesselByGrad(navalVessels , user_purpose);
        if (result == null) {
            System.out.println("No Naval Vessel is available with the specified purpose");
        }
        else{
            System.out.println(result.getvesselName() + "%" + result.getclassification());
        }
    }
}