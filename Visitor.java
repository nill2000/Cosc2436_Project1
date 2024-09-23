public class Visitor {

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

  //Setters
  public void setName(){
  };

  public void setAge(){
  };

  public void setTicket(){
  };

  public void setRide(){
  };

  //Getters
  public String getName(){
    return name;
  };

  public int getAge(){
    return age;
  };

  public String getTicket(){
    return ticket;
  };

  public String getRide(){
    return ride;
  };

  //General Form
  public void setDetails(){

  }

  public void getDetails(){

  }

  public static void main(String[] args) {
    System.out.println("Success in Visitor Class");
  }
}
