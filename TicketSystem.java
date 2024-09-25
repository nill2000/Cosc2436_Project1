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
      if (visitorAge > 0 && visitorAge < 18){
        visitorTicket = visitorObj.ticketType[0];
      } else if (visitorAge >= 18 && visitorAge < 60){
        visitorTicket = visitorObj.ticketType[1];
      } else if (visitorAge >= 60 && visitorAge <= 100){
        visitorTicket = visitorObj.ticketType[2];
      } else {
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
          visitorRide = visitorObj.ridePreference[0];
          break;
        case 2:
          visitorRide = visitorObj.ridePreference[1];
          break;
        case 3:
          visitorRide = visitorObj.ridePreference[2];
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

    //joinRideQueue Method
    public void joinRideQueue(Visitor visitor, String rideName){
      switch(rideName){
        case "Ferris Wheel":
          ferrisWheelList.add(visitor);
          break;
        case "Roller Coaster":
          rollerCoasterList.add(visitor);
          break;
        case "Dropper":
          dropperList.add(visitor);
          break;
        default:
        System.out.println("Error Occured \nExitting Program");
          System.exit(0);
      }
      System.out.println(visitor.name + " Added to " + rideName + " Queue.");
    }

    // shoeCurrentQueue Method
    public void showCurrentQueue(){
      //Displays Current Ferris Wheel Queue
      if (!ferrisWheelList.isEmpty()){
        System.out.println("Ferris Wheel Queue (Names): ");
        for(int i = 0; i < ferrisWheelList.size(); i++){
          System.out.println(ferrisWheelList.get(i).getName());
        } System.out.println();
      } else {
        System.out.println("Ferris Wheel Queue is Empty");
      }

      //Displays Current Roller Coaster Queue
      if (!rollerCoasterList.isEmpty()){
        System.out.println("Roller Coaster Queue (Names): ");
        for(int i = 0; i < rollerCoasterList.size(); i++){
          System.out.println(rollerCoasterList.get(i).getName());
        } System.out.println();
      } else {
        System.out.println("Roller Coaster Queue is Empty");
      }

      //Displays Current Dropper Queue
      if (!dropperList.isEmpty()){
        System.out.println("Dropper Queue (Names): ");
        for(int i = 0; i < dropperList.size(); i++){
          System.out.println(dropperList.get(i).getName());
        } System.out.println();
      } else {
        System.out.println("Dropper Queue is Empty");
      }
    }

    //simulateRide Method
    public void simulateRide(){
      int rideTime = randonObj.nextInt(4) + 1;
      System.out.println("Ride will last " + rideTime + " seconds");

      for(int i = rideTime; i > 0; i--){
        System.out.println("Seconds Remaining: "+ i);
        try{
          Thread.sleep(1000);
        } catch(InterruptedException e){
          System.err.println(e);
        }
      }
      
      //Remove Visitors from Queue
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
          Thread.sleep(1000);
        } catch(InterruptedException e){
          System.err.println(e);
        }
      }
      System.out.println("Begin Ride \n");
    }
}
