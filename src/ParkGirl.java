import java.util.ArrayList;
import java.util.Scanner;

public class ParkGirl {

  public ParkGirl() {
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

  public void printWelcome() {
    System.out.println(
            " Welcome to ParkGirl garage! \n" + " Our opening hours are 00.00-24.00, all week Monday to Sunday");
  }

  public void printPrice() {
    System.out.println(" Price option: \n" + " 10 kr/hour up to 5 hours \n" + " 50 kr/day \n" + " 350 kr/week \n ");
  }

  public void printMenu() {
    Scanner scan = new Scanner(System.in);

    while (true) {
      System.out.println("Number of vacancies: " + (15 - checkedCars.size()) + " of 15");
      System.out.println("1. Would you like to check in you car?\n"
              + "2. Do you want to pay and exit the parking?\n" + "3. Terminate software");

      System.out.println("Please enter your option:");

      String option = scan.nextLine();
      Boolean registrationError = false;
      while (option.equals("1")) {
        if (checkedCars.size() >= 15) {
          System.out.println(
                  "Parking is full at the moment. We apologise for any inconvenience, please return at a "
                          + "later date.");
          break;
        }

        if (registrationError) {
          System.out.println("You need to enter a valid registration number, A-Z and 0-9. Car number must be "
                  + "of 2-7 characters and/or digits. Please try again or enter \"0\" to Exit to Startpage.");
        } else {
          System.out.println("Please enter a valid Registration number, A-Z and 0-9."
                  + "Registration number must be of 2-7 characters and/or digits.");
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
      } // whole option 1

      while (option.equals("2")) {

        if (registrationError) {
          System.out.println("You need to enter a valid registration number, A-Z and 0-9. Car number must be "
                  + "of 2-7 characters and/or digits. Please try again or enter \"0\" to Exit to Startpage.");
        } else {
          System.out.println("Please enter your Registration number to pay.");
        }
        String registrationNumber = scan.nextLine();
        registrationNumber = registrationNumber.replace(" ", "").toUpperCase();

        if (registrationNumber.equals("0"))
          break;

        if (!registrationNumber.matches("^[A-Z0-9]{2,7}$")) {
          registrationError = true;
          continue;
        }

        System.out.println("How long have you been parked? 1. Hours, 2. Days or 3. Weeks? \n"
                + "To Exit to Startpage, enter \"0\" and press Enter.");

        System.out.println("Please enter your option:");

        String checkout = scan.nextLine();


        String temp;
        int number;

        if (checkout.equals("1")) {
          System.out.println("Please enter how many hours you've been parked");

          temp = scan.nextLine();

          number = Integer.parseInt(temp);


          int price = 0;
          int hours = number;

          if (hours <= 5) { // =< doesnt exist theres only <=
            price = 50;
            price += (hours - 50) % 1;
          } else if (hours < 24 && hours > 5) {
            price = 50;
            price += (hours - 5) * 1;
          } else {
            price = hours * 5;
          }
          System.out.println("Hours: " + hours + " Price: " + price);

        } else if (checkout.equals("2")) {
          System.out.println("Please enter how many days you've been parked");
          // scan.nextLine();
        } else if (checkout.equals("3")) {
          System.out.println("Please enter how many weeks you've been parked");
          // scan.nextLine();
        } else if (checkout.equals("0")) {
          break;
        }

        System.out.println("Which payment method would you like to use? \n"
                + "1. Card Payment. or 2. Invoice? \n" + "To Exit to Startpage, enter \"0\" and press Enter.");

        System.out.println("Please enter your option:");

        String payment = scan.nextLine();
        String cardNumber;
        boolean flag = false;
        if (payment.equals("1")) {

          System.out.println("Please enter your card number");
          cardNumber = scan.nextLine();
          while (!cardNumber.matches("^[0-9]{10,10}$")) {
            System.out.println("The card number you entered is invalid, use only numbers between 0-9. \n");
            System.out.println("Please try again or enter \"0\" to Exit to Startpage.");

            cardNumber = scan.nextLine();// this enters it each other time
            registrationNumber = cardNumber.replace(" ", "").toUpperCase();
            registrationNumber = cardNumber.replace("-", "").toUpperCase();

            if (cardNumber.equals("0")) {
              System.out.println("UNHANDLED BREAK OUT");
              flag = true;
              break;

            }

          }

          if (flag) {
            break;
          }else {
            //removes the car from the list

            int x = -1;
            for (int i = 0; i < checkedCars.size(); i++) {
              CheckedCar cc = checkedCars.get(i);
              if (cc != null) {
                if (cc.getregnum().equals(registrationNumber)) {
                  x = i;
                  break;
                }
              }
            }

            if (x == -1) {
              System.out.println("ERROR");

            } else {

              checkedCars.remove(x);
              System.out.println(
                      "Thank you for your parking! Hours: 2, Total: 20 SEK Have a nice day and welcome back!");
            } //whole option 1. Card payment
          } //lägg in invoice här



        }

      }

    } // while print menu
  } // print menu metod
} // class

