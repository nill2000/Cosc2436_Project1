import java.util.Scanner;
public class TicketSystem {
    
    static void purchaseTicket(Visitor visitor){

      Scanner obj1Scanner = new Scanner(System.in);

      System.out.println("What is your age?");
      int age = obj1Scanner.nextInt();
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

      obj1Scanner.close();
    }

    static void joinRideQueue(Visitor visitor, String rideName){
      

    }

    static void simulateRide(){

    }



    public static void main(String[] args) {
    Visitor objVisitor = new Visitor();
    purchaseTicket(objVisitor);
  }
  
}
