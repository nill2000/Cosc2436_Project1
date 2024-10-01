public class Visitor {

  public static void main(String[] args) {
    System.out.println("Success in Visitor Class");
  }

  //Variables for the Visitors
  String name;
  int age;
  String[] ticketType = {"Child", "Adult", "Senior"};
  String ticket;
  String[] ridePreference = {"Ferris Wheel", "Roller Coaster", "Dropper"};
  String ride;

  //Constructor
  public Visitor(String name, int age, String ticket, String ride){
    this.name = name;
    this.age = age;
    this.ticket = ticket;
    this.ride = ride;
  }

  //Getter to Display Names in Current Queue
  public String getName(){
    return name;
  };
}
