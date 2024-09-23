import java.util.Scanner;
public class Main {
  
  private static TicketSystem ticketSystemObj = new TicketSystem();
  private static Scanner scannerObj = new Scanner(System.in);
  private static Visitor visitorObj = new Visitor(null, 0, null, null);

  static void menuList(){
      System.out.println("Ticket Menu:");
      System.out.println("1. Add Visitor");
      System.out.println("2. Add Visitor to Queue");
      System.out.println("3. Simulate Ride");
      System.out.println("4. Exit Program");
      int menuChoice = scannerObj.nextInt();

      switch(menuChoice){
        case 1:
          // purchaseTicket2(visitorsList);
          break;
        case 2:
          // joinRideQueue(null, null);
          break;
        case 3:
          // rideCountDown();
          // simulateRide();
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
    
  }
}

