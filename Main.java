import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Queue;


public class Main {
  public static void main(String[] args) {
    Scanner scannerObj = new Scanner(System.in);

    System.out.println("How old are you?");
    int age = scannerObj.nextInt();

    System.out.println("What do you want to ride? (Please Answer with Corresponding Number) \n1. Ferris Wheel \n2. Roller Coaster \n3. Dropper");
    int rideName = scannerObj.nextInt();

    System.out.println();
    System.out.println(age);
    System.out.println(rideName);

    scannerObj.close();
  }
}

