import java.util.ArrayList;
import java.util.Scanner;

public class ParkGirl{

  public ParkGirl(){
    CheckedCar cc = new CheckedCar("ABC124");
    checkedCars.add(cc);
    cc = new CheckedCar("ABC125");
    checkedCars.add(cc);
    cc = new CheckedCar("ABC126");
    checkedCars.add(cc);
    cc = new CheckedCar("ABC127");
    checkedCars.add(cc);
    cc = new CheckedCar("ABC128");
    checkedCars.add(cc);
    cc = new CheckedCar("ABC129");
    checkedCars.add(cc);
    cc = new CheckedCar("ABB124");
    checkedCars.add(cc);
    cc = new CheckedCar("ABB125");
    checkedCars.add(cc);
    cc = new CheckedCar("ABB126");
    checkedCars.add(cc);
    cc = new CheckedCar("ABB127");
    checkedCars.add(cc);
    cc = new CheckedCar("ABB128");
    checkedCars.add(cc);
    cc = new CheckedCar("ABB129");
    checkedCars.add(cc);
  }

  private ArrayList<CheckedCar> checkedCars = new ArrayList<>();

  public void printWelcome(){
    System.out.println(" Welcome to ParkGirl garage! \n" +
                        " Our opening hours are 00.00-24.00, all week Monday to Sunday");
  }

  public void printPrice(){
    System.out.println(" Price option: \n" +
                        " 10 kr/hour up to 5 hours \n" +
                        " 50 kr/day \n" +
                        " 350 kr/week \n ");
  }

  public void printMenu(){
    Scanner scan = new Scanner(System.in);

      while(true) {
        System.out.println("Number of vacancies: " + (15-checkedCars.size()) + " of 15");
        System.out.println("1. Would you like to check in you car?\n" +
                "2. Do you want to pay and exit the parking?\n" +
                "3. Terminate software");

        System.out.println("Please enter your option:");

        String option = scan.nextLine();

        Boolean registrationError = false;
        while (option.equals("1")) {
          if (checkedCars.size() >= 15) {
            System.out.println("Parking is full at the moment. We apologise for any inconvenience, please return at a " +
                    "later date.");
            break;
          }


          if (registrationError) {
            System.out.println("You need to enter a valid registration number, A-Z and 0-9. Car number must be " +
                    "of 2-7 characters and/or digits. Please try again or enter \"0\" to Exit to Startpage.");
          } else {
            System.out.println("Please enter a valid registration number, A-Z and 0-9."
                    + "Car number must be of 2-7 characters and/or digits.");
          }
          String registrationNumber = scan.nextLine();
          registrationNumber = registrationNumber.replace(" ", "").toUpperCase();

          if (registrationNumber.equals("0"))
            break;

          if (!registrationNumber.matches("^[A-Z0-9]{2,7}$")) {
            registrationError = true;
            continue;
          }

          CheckedCar cc = new CheckedCar(registrationNumber);
          checkedCars.add(cc);

          System.out.println("Thank you, your car " + registrationNumber + " is now checked in.");

          break;
        }

        if (option.equals("2")) {
          System.out.println("Please enter your registration number to pay");
          //mer kod här
          System.out.println("How long have you been parked? 1. Hours, 2. Days or 3. Weeks? \n" +
                      "To Exit to Startpage, enter \"0\" and press Enter.");

          /*mer kod här
          if (hours =< 5) {
            price = 50;
            price += (hours - 50) % 1;
          } else if (hours < 24 && hours > 5) {
            price = 50;
            price += (hours - 5) * 1;
          } else {
            price = hours * 5;
          }
          System.out.println("Hours: " + hours + " Price: " + price); */

          //Massa mer kod här

          System.out.println("Which payment method would you like to use? \n" +
                      "1. Card Payments. or 2. Invoice?");
          //mer kod här
        } else if (option.equals("3")) {
          break;
        }

      }
    }
  } //class
