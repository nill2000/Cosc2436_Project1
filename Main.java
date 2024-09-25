import java.util.Scanner;
public class Main {
  
  private static TicketSystem ticketSystemObj = new TicketSystem();
  private static Scanner scannerObj = new Scanner(System.in);

  public static void main(String[] args) {
    boolean Running = true;

      while(Running){
        System.out.println();
        menuList();
      }
  }

  static void menuList(){
      System.out.println("Ticket Menu (Corresponding Integer):");
      System.out.println("1. Add Visitor");
      System.out.println("2. Add Current Visitor to Queue");
      System.out.println("3. Show Current Ride Queues");
      System.out.println("4. Simulate Ride");
      System.out.println("5. Exit Program");
      int menuChoice = scannerObj.nextInt();

      switch(menuChoice){
        case 1:
          ticketSystemObj.purchaseTicket(ticketSystemObj.visitorStack);
          break;

        case 2:
          if (!ticketSystemObj.visitorStack.empty()){
            Visitor curVisitor = ticketSystemObj.visitorStack.pop();
            String curVisitorRide = curVisitor.ride;
            ticketSystemObj.joinRideQueue(curVisitor, curVisitorRide);
          } else {
            System.out.println("No Visitors Available");
          }
          break;

        case 3:
          ticketSystemObj.showCurrentQueue();
          break;

        case 4:
          ticketSystemObj.rideCountDown();
          ticketSystemObj.simulateRide();
          break;

        case 5:
          System.out.println("Exitting Program");
          System.exit(0);

        default:
          System.out.println("Invalid Input \nExitting Program");
          System.exit(0);
      }
    }
}

