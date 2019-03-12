import java.util.Scanner;

public class ParkGirl{

  private void printWelcome(){
    System.out.println(" Welcome to ParkGirl garage! \n" +
                        "Our opening hours are 00.00-24.00, all week Monday to Sunday");
  }

  private void printPrice(){
    System.out.println(" Price option: \n" +
                        " 10 kr/hour up to 5 hours \n" +
                        " 50 kr/day \n" +
                        " 350 kr/week \n ");
  }

  private void printVacancies(){
    System.out.println(" Number of vacancies: ");
  }

  private void printMenu(){
    Scanner scan = new Scanner(System.in);

    while(true){
      String choice = "";
      System.out.println("1. Would you like to check in you car?.\n"+
                     "2. Do you want to pay and exit the parking?.\n"+
                     "3. Terminate software.");

      System.out.println("Please enter your option:");

      while(true){
        option = scan.nextLine();
        if(option.equals("1") || option.equals("2")) || option.equals("3");
        break;

        while(option.equals ("1"){
          System.out.println("Please enter a valid car number, A-Z and 0-9.
                            Car number must be of 2-7 characters and/or digits.");
                            //Mer kod här
                          }

        if(option.equals("2") {
          System.out.println("Please enter your car number to pay");
          //mer kod här
          System.out.println("How long have you been parked? 1. Hours or 2. Days?
                              To Exit to Startpage, enter "0" and press Enter.");
                              //Massa mer kod här
                        }

        else if (option.equals ("3"){
          break;
          }

        }
      }
    }
  }

public static void main(String[] args) {}

}
