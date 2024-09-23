import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;
import java.util.Queue;

public class TicketSystem {
    //Creates Random object named randNum
    private static Random randNum = new Random();

    //Creates Scanner object named objScanner
    private static Scanner objScanner = new Scanner(System.in);

    //Creates Visitor object named visitorObj
    public static Visitor visitorObj = new Visitor(null, 0, null, null);

    //List to hold type Visitor
    private static ArrayList<Visitor> visitorsArrayList = new ArrayList<Visitor>();
    static Stack<Visitor> visitorStack = new Stack<>();
    Visitor [] visitorList_ = {};

    //Use arraylist for queue
    private static ArrayList<Visitor> ferrisWheelList = new ArrayList<Visitor>();
    private static ArrayList<Visitor> rollerCoasterList = new ArrayList<Visitor>();
    private static ArrayList<Visitor> dropperList = new ArrayList<Visitor>();


    
    //PurchaseTicket uses LIST
    static void purchaseTicket(Visitor[] visitor){
      System.out.println();

      //Inputs Visitor's Name
      System.out.println("Name: ");
      String visitorName = objScanner.next();
      System.out.println();

      //Inputs Visitor's Age
      System.out.println("Age: ");
      int visitorAge = objScanner.nextInt();
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
      int rideChoice = objScanner.nextInt();
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
      //Append VisitorObj to list // Uses List
      
    }

    //PurchaseTicket uses ARRAYLIST
    static void purchaseTicket2(ArrayList<Visitor> arrayListVisitor){
      System.out.println();

      //Inputs Visitor's Name
      System.out.println("Name: ");
      String visitorName = objScanner.next();
      System.out.println();

      //Inputs Visitor's Age
      System.out.println("Age: ");
      int visitorAge = objScanner.nextInt();
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
      int rideChoice = objScanner.nextInt();
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
      arrayListVisitor.add(visitorObj); //ArrayList
    }

    //PurchaseTicket uses STACK - MAYBE COMPLETE
    static void purchaseTicket3(Stack<Visitor> listStackVisitor){
      System.out.println();

      //Inputs Visitor's Name
      System.out.println("Name: ");
      String visitorName = objScanner.next();
      System.out.println();

      //Inputs Visitor's Age
      System.out.println("Age: ");
      int visitorAge = objScanner.nextInt();
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
      int rideChoice = objScanner.nextInt();
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
        System.exit(0);
      }
      System.out.println(visitor.name + " has been added to " + rideName + " Queue.");

    }

    //Function 4
    static void simulateRide(){
      System.out.println("Rides will last 5 seconds");
      //Use random timer
      //Pop visitor from ride queue
    }

    //Function 5 COMPLETE
    static void rideCountDown(){
      for(int i = 3; i > 0; i--){
        System.out.println("Ride will be in " + i);
      }
      System.out.println("Begin Ride \n");

    }

    //Function 6
    static void menuList(){
      System.out.println("Ticket Menu:");
      System.out.println("1. Add Visitor");
      System.out.println("2. Add Current Visitors to Queue");
      System.out.println("3. Simulate Ride");
      System.out.println("4. Exit Program");
      int menuChoice = objScanner.nextInt();

      switch(menuChoice){
        case 1:
          purchaseTicket3(visitorStack);
          break;
        case 2:
          Visitor curVisitor = visitorStack.pop();
          String curVisitorRide = curVisitor.ride;
          joinRideQueue(curVisitor, curVisitorRide);
          break;
        case 3:
          rideCountDown();
          simulateRide();
          break;
        case 4:
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

      // Visitor objVisitor = new Visitor();
      // purchaseTicket(objVisitor);
      // joinRideQueue(objVisitor, "Hello");
  }
  
}
