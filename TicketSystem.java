import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TicketSystem {
    
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

    static void purchaseTicket2(ArrayList<Visitor> visitor, int visitorNum){

      Scanner objScanner = new Scanner(System.in);

      for(int i = 0; i < visitorNum; i++){
        
      }

      
    }

    static void joinRideQueue(Visitor visitor, String rideName){
      Scanner objScanner = new Scanner(System.in);

      System.out.println("Which ride for? " + visitor.name + " (Please Answer with Corresponding Number) \n1. Ferris Wheel \n2. Roller Coaster \n3. Dropper");
      int rideChoice = objScanner.nextInt();

      System.out.println(visitor.name + " has selected " + visitor.ridePreference[rideChoice - 1]);
      // obj2Scanner.close();

    }

    static void simulateRide(){

    }



    public static void main(String[] args) {
    Random randNum = new Random();
    int numOfVisitors = randNum.nextInt(5) + 1; //Generate random numbers between 1-5
    System.out.println("You have " + numOfVisitors + " visitors");
    ArrayList<Visitor> visitors = new ArrayList<Visitor>(numOfVisitors); //Create list of type Visitor 
    
    // purchaseTicket2(visitors);
    // Visitor objVisitor = new Visitor();
    // purchaseTicket(objVisitor);
    // joinRideQueue(objVisitor, "Hello");
  }
  
}
