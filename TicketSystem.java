import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class TicketSystem {
    //Creates Random object to generate random number
    private Random randonObj = new Random();

    //Creates Scanner object for input
    private Scanner scannerObj = new Scanner(System.in);

    //Creates Visitor object named visitorObj
    private Visitor visitorObj = new Visitor(null, 0, null, null);

    //Crates a Stack of type Visitor
    public Stack<Visitor> visitorStack = new Stack<>();

    //Creates ArrayList for Each Ride Queue of Type Visitor
    private ArrayList<Visitor> ferrisWheelList = new ArrayList<Visitor>();
    private ArrayList<Visitor> rollerCoasterList = new ArrayList<Visitor>();
    private ArrayList<Visitor> dropperList = new ArrayList<Visitor>();

    //main Method in TicketSystem Class to show no errors occurred
    public static void main(String[] args) {
      System.out.println("TicketSystem Class Sucess");
  }


    //PurchaseTicket Method
    public void purchaseTicket(Stack<Visitor> listStackVisitor){
      System.out.println();

      //Inputs Visitor's Name
      System.out.println("Name: ");
      String visitorName = scannerObj.next();
      System.out.println();

      //Inputs Visitor's Age
      System.out.println("Age (1-100): ");
      int visitorAge = scannerObj.nextInt();
      String visitorTicket = "";
      System.out.println();

      //Gets Ticket Type Based on Age
      if (visitorAge > 0 && visitorAge < 18){ //If age is 0-17, visitor receives child ticket because ticketType[0] from Visitor class is Child
        visitorTicket = visitorObj.ticketType[0];
      } else if (visitorAge >= 18 && visitorAge < 60){ //If age is 18-59, visitor receives adult ticket because ticketType[1] from Visitor class is adult
        visitorTicket = visitorObj.ticketType[1];
      } else if (visitorAge >= 60 && visitorAge <= 100){ //If age is 60-100, visitor receives senior ticket because ticketType[2] from Visitor class is senior
        visitorTicket = visitorObj.ticketType[2];
      } else { //Invalid Input exits program
        System.out.println("Invalid Input \nExitting Program");
        System.exit(0);
      }
      System.out.println(visitorName + " receives " + visitorTicket + " ticket");
      System.out.println();

      //Gets the Ride Choice
      System.out.println("Rides Available (Please Answer with Corresponding Number): \n1. Ferris Wheel \n2. Roller Coaster \n3. Dropper ");
      int rideChoice = scannerObj.nextInt();
      String visitorRide = "";

      //Gets the Visitor's Ride based on case statements from visitor object
      switch(rideChoice){
        case 1:
          visitorRide = visitorObj.ridePreference[0]; //If input was 1, visitor receives ferris wheel ride because ridePreference[0] in Visitor class is ferris wheel
          break;
        case 2:
          visitorRide = visitorObj.ridePreference[1]; //If input was 2, visitor receives roller coaster ride because ridePreference[0] in Visitor class is roller coaster
          break;
        case 3:
          visitorRide = visitorObj.ridePreference[2]; //If input was 3, visitor receives dropper ride because ridePreference[0] in Visitor class is dropper
          break;
        default:
          System.out.println("Invalid Input \nExitting Program");
          System.exit(0);
      }
      System.out.println(visitorName + " selects " + visitorRide + " ride");

      //Creates a Visitor Object with Corresponding Details
      visitorObj = new Visitor(visitorName, visitorAge, visitorTicket, visitorRide);
      //Adds the Visitor Object to the Visitor Stack
      listStackVisitor.push(visitorObj);
    }

    //joinRideQueue Method that takes argument of visitor and ride to place them on the correct ArrayList
    public void joinRideQueue(Visitor visitor, String rideName){
      switch(rideName){
        case "Ferris Wheel": //If visitor's ride was Ferris wheel, visitor will be added to ferris wheel list
          ferrisWheelList.add(visitor);
          break;
        case "Roller Coaster": //If visitor's ride was roller coaster, visitor will be added to roller coaster list
          rollerCoasterList.add(visitor);
          break;
        case "Dropper": //If visitor's ride was dropper, visitor will be added to dropperlist
          dropperList.add(visitor);
          break;
        default: //Checks for error and exits
          System.out.println("Error Occured \nExitting Program");
          System.exit(0);
      }
      System.out.println(visitor.name + " Added to " + rideName + " Queue.");
    }

    // shoeCurrentQueue Method
    public void showCurrentQueue(){
      //Displays Current Ferris Wheel Queue
      if (!ferrisWheelList.isEmpty()){ //If ferris wheel list isnt empty, print out every visitor's name
        System.out.println("Ferris Wheel Queue (Names): ");
        for(int i = 0; i < ferrisWheelList.size(); i++){
          System.out.println(ferrisWheelList.get(i).getName());
        } System.out.println();
      } else { //If nobody is in ferris wheel
        System.out.println("Ferris Wheel Queue is Empty");
      }

      //Displays Current Roller Coaster Queue
      if (!rollerCoasterList.isEmpty()){ //If roller coaster list isnt empty, print out every visitor's name
        System.out.println("Roller Coaster Queue (Names): ");
        for(int i = 0; i < rollerCoasterList.size(); i++){
          System.out.println(rollerCoasterList.get(i).getName());
        } System.out.println();
      } else { //If nobody is in roller coaster
        System.out.println("Roller Coaster Queue is Empty");
      }

      //Displays Current Dropper Queue
      if (!dropperList.isEmpty()){ //If dropper list isnt empty, print out every visitor's name
        System.out.println("Dropper Queue (Names): ");
        for(int i = 0; i < dropperList.size(); i++){
          System.out.println(dropperList.get(i).getName());
        } System.out.println();
      } else { //If nobody is in dropper
        System.out.println("Dropper Queue is Empty");
      }
    }

    //simulateRide Method
    public void simulateRide(){
      int rideTime = randonObj.nextInt(4) + 1; //Generates random number from 1-5 for countdown
      System.out.println("Ride will last " + rideTime + " seconds");

      for(int i = rideTime; i > 0; i--){ 
        System.out.println("Seconds Remaining: "+ i);
        try{
          Thread.sleep(1000); //Function imitates real time 1 second for ride simulation
        } catch(InterruptedException e){
          System.err.println(e);
        }
      }
      
      //Remove Visitors from Respective Queue after finishing ride
      ferrisWheelList.clear();
      rollerCoasterList.clear();
      dropperList.clear();
      System.out.println("Visitors in Queue have been Removed");
    }

    //rideCountDown Method
    public void rideCountDown(){

      System.out.println("Begins in");
      for(int i = 3; i > 0; i--){
        System.out.println(i);
        try{
          Thread.sleep(1000); //Function imitates real time 1 second for count down before ride
        } catch(InterruptedException e){
          System.err.println(e);
        }
      }
      System.out.println("Begin Ride \n");
    }
}
