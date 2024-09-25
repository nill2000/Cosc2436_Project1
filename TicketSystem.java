import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;


public class TicketSystem {
    //Creates Random object to generate random number
    private static Random randonObj = new Random();

    //Creates Scanner object for input
    private static Scanner scannerObj = new Scanner(System.in);

    //Creates Visitor object named visitorObj
    public static Visitor visitorObj = new Visitor(null, 0, null, null);

    //Crates a Stack of type Visitor
    private static Stack<Visitor> visitorStack = new Stack<>();

    //Use arraylist for queue
    private static ArrayList<Visitor> ferrisWheelList = new ArrayList<Visitor>();
    private static ArrayList<Visitor> rollerCoasterList = new ArrayList<Visitor>();
    private static ArrayList<Visitor> dropperList = new ArrayList<Visitor>();


    //PurchaseTicket uses STACK - MAYBE COMPLETE
    static void purchaseTicket(Stack<Visitor> listStackVisitor){
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


      visitorObj = new Visitor(visitorName, visitorAge, visitorTicket, visitorRide);
      listStackVisitor.push(visitorObj); //The Stack
    }

    //Function 3
    //Match ride name into the ride queue
    static void joinRideQueue(Visitor visitor, String rideName){
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

    static void showCurrentQueue(){
      if (!ferrisWheelList.isEmpty()){

      } else {
        System.out.println("Ferris Wheel Queue is Empty");
      }

      if (!rollerCoasterList.isEmpty()){

      } else {
        System.out.println("Roller Coaster Queue is Empty");
      }

      if (!dropperList.isEmpty()){

      } else {
        System.out.println("Dropper Queue is Empty");
      }
    }

    //Function 4
    static void simulateRide(){
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
      System.out.println("Visitors have been removed from all 3 Queues");
    }

    //Function 5 COMPLETE
    static void rideCountDown(){

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

    //Function 6
    static void menuList(){
      System.out.println("Ticket Menu (Corresponding Integer):");
      System.out.println("1. Add Visitor");
      System.out.println("2. Add Current Visitors to Queue");
      System.out.println("3. Show Current Ride Queues");
      System.out.println("4. Simulate Ride");
      System.out.println("5. Exit Program");
      int menuChoice = scannerObj.nextInt();

      switch(menuChoice){
        case 1:
          purchaseTicket(visitorStack);
          break;
        case 2:
          if (!visitorStack.empty()){
            Visitor curVisitor = visitorStack.pop();
            String curVisitorRide = curVisitor.ride;
            joinRideQueue(curVisitor, curVisitorRide);
          } else {
            System.out.println("No Visitors Available");
          }
          break;
        case 3:
          showCurrentQueue();
          break;
        case 4:
          rideCountDown();
          simulateRide();
          break;
        case 5:
          System.out.println("Exitting Program");
          System.exit(0);
        default:
          System.out.println("Invalid Input \nExitting Program");
          System.exit(0);
      }
    }

    public static void main(String[] args) {

      boolean Running = true;

      while(Running){
        System.out.println();
        menuList();
      }
  }
}
