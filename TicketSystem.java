import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TicketSystem {
    private static Random randNum = new Random();
    private static Scanner objScanner = new Scanner(System.in);
    public static Visitor visitorObj = new Visitor(null, 0, null, null);
    
    //Function 1
    static void purchaseTicket(Visitor visitor){

      Scanner objScanner = new Scanner(System.in);

      System.out.println("What is your name?");
      String name = objScanner.next();
      visitor.name = name;

      System.out.println("What is your age?");
      int age = objScanner.nextInt();
      visitor.age = age;

      if (visitor.age > 0 && visitor.age < 18){
        visitor.ticket = visitor.ticketType[0];
        System.out.println("Success 1");
        System.out.println("Person is " + visitor.age + " years old");
        System.out.println("Person receives " + visitor.ticket + " ticket");
      } 

      else if (visitor.age >= 18 && visitor.age < 60){
        visitor.ticket = visitor.ticketType[1];
        System.out.println("Success 2");
        System.out.println("Person is " + visitor.age + " years old");
        System.out.println("Person receives " + visitor.ticket + " ticket");
      } 

      else if (visitor.age >= 60 && visitor.age <= 100){
        visitor.ticket = visitor.ticketType[2];
        System.out.println("Success 3");
        System.out.println("Person is " + visitor.age + " years old");
        System.out.println("Person receives " + visitor.ticket + " ticket");
      } 

      else {
        System.out.println("Invalid Age. \nExiting Program");
        System.exit(0);
      }

      
    }

    //Function 2
    static void purchaseTicket2(ArrayList<Visitor> visitor){

      System.out.println("Name: ");
      String visitorName = objScanner.next();

      System.out.println("Age: ");
      int visitorAge = objScanner.nextInt();

      System.out.println("Ticket: ");
      String visitorTicket = objScanner.next();

      System.out.println("Rides Available (Please Answer with Corresponding Number) \n1. Ferris Wheel \n2. Roller Coaster \n3. Dropper: ");
      int rideChoice = objScanner.nextInt();

      switch(rideChoice){
        case 1:
        case 2:
        case 3:
        default:
        System.out.println("Invalid Input \nExitting Program");
        System.exit(0);
      }

      visitorObj = new Visitor(visitorName, visitorAge, visitorTicket, visitorTicket);

      
    }

    //Function 3
    static void joinRideQueue(Visitor visitor, String rideName){
      Scanner objScanner = new Scanner(System.in);

      System.out.println("Which ride for? " + visitor.name + " (Please Answer with Corresponding Number) \n1. Ferris Wheel \n2. Roller Coaster \n3. Dropper");
      int rideChoice = objScanner.nextInt();

      System.out.println(visitor.name + " has selected " + visitor.ridePreference[rideChoice - 1]);
      // obj2Scanner.close();

    }

    //Function 4
    static void simulateRide(){
      System.out.println("Rides will last 5 seconds");
      //Use random timer
      //Pop visitor from ride queue
    }

    //Function 5
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
      System.out.println("2. Add Visitor to Queue");
      System.out.println("3. Simulate Ride");
      System.out.println("4. Exit Program");
      int menuChoice = objScanner.nextInt();

      switch(menuChoice){
        case 1:
          purchaseTicket2(null);
          break;
        case 2:
          joinRideQueue(null, null);
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
    
    ArrayList<Visitor> visitorsList = new ArrayList<Visitor>(); //Create list of type Visitor 
    
    purchaseTicket2(visitorsList);
    // Visitor objVisitor = new Visitor();
    // purchaseTicket(objVisitor);
    // joinRideQueue(objVisitor, "Hello");
  }
  
}
