import java.util.Scanner;
public class Main {
  
  private static TicketSystem ticketSystemObj = new TicketSystem(); //Creates a TicketSystem object to utilize TicketSystem attributes - ticketSystemObj
  private static Scanner scannerObj = new Scanner(System.in); //Creates a Scanner object for user input - scannerObj

  public static void main(String[] args) {
    boolean Running = true; //Sets the boolean variable to continue program. I used a variable for more control.

      while(Running){ //Runs the program forever unless user decides to terminate from one of menu options
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
      int menuChoice = scannerObj.nextInt(); //Takes user input to evoke a menuChoice

      switch(menuChoice){
        case 1: //If menuChoice is one, program will use the purchaseTicket method from TicketSystem Class and place it in the visitorStack. 
          ticketSystemObj.purchaseTicket(ticketSystemObj.visitorStack);
          break;

        case 2: //If menuChoice is two, the program will check if the list has people before adding. Else, prints a message that there are no visitors.
          if (!ticketSystemObj.visitorStack.empty()){
            Visitor curVisitor = ticketSystemObj.visitorStack.pop(); //Takes the most current visitor from the stack, removes them, and saves it into a variable.
            String curVisitorRide = curVisitor.ride; //Takes the current Visitor's ride choice and saves into a variable. 
            ticketSystemObj.joinRideQueue(curVisitor, curVisitorRide); // The current visitor will be placed into the queue corresponding with their ride choice
          } else {
            System.out.println("No Visitors Available");
          }
          break;

        case 3:
          ticketSystemObj.showCurrentQueue(); //List the visitors in the current queue
          break;

        case 4:
          ticketSystemObj.rideCountDown(); //A 3 second before ride simulation
          ticketSystemObj.simulateRide(); //Ride simulation begins for a random timer of 1-5 seconds and removes visitors from queue
          break;

        case 5: //If menuChoice is 5, program will exit
          System.out.println("Exitting Program");
          System.exit(0);

        default: //If menuChoice is anything other than the listed values, program will terminate
          System.out.println("Invalid Input \nExitting Program");
          System.exit(0);
      }
    }
}

