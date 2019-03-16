import java.util.ArrayList;
import java.util.Scanner;

public class ParkGirl{

  public ParkGirl(){
    addCars();
    addCards();
  }

  private void addCars() {
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

  private void addCards(){
    Card ac = new Card("9124343422", 0, true);
    cards.add(ac);
    ac = new Card("5678252588", 0);
    cards.add(ac);
    ac = new Card("1234656577", 10);
    cards.add(ac);
    ac = new Card("1234454555", 10000);
    cards.add(ac);
  }
  private ArrayList<Card> cards = new ArrayList<>();
  private ArrayList<CheckedCar> checkedCars = new ArrayList<>();

  public void printWelcome(){
    System.out.println(" *************************************\n" +
                      "     Welcome to ParkGirl Garage! \n" +
                      "  Our opening hours are 00.00-24.00,\n " +
                      "         Monday to Sunday\n " +
                      "************************************* \n");
  }

  public void printPrice(){
    System.out.println(" Our prices: \n" +
                        " 10 SEK/hour up to 5 hours \n" +
                        " 50 SEK/day \n");
  }

  public String cleanupString(String str){
    String result = str.replace("-", "").replace(" ", "")
            .replace(".", "").replace(",", "").toUpperCase();
    return result;
  }

  public void startGarage(){
    Scanner scan = new Scanner(System.in);

      while(true) {
        printMainMenu();

        String option = scan.nextLine();

        Boolean registrationError = false;
        while (option.equals("1")) {
          if (checkedCars.size() >= 15) {
            System.out.println("There are no parking spots available at the moment. We apologise for any inconvenience, please return at a " +
                    "later date.");
            break;
          }


          if (registrationError) {
            System.out.println("You need to enter a valid registration number, A-Z and 0-9. Car number must be " +
                    "of 2-7 characters and/or digits.\n" + "Please try again or enter \"0\" to Exit to Startpage.");
          } else {
            System.out.println("Please enter a valid registration number, A-Z and 0-9."
                    + "Registration number must be of 2-7 characters and/or digits.");
          }
          String registrationNumber = scan.nextLine();
          registrationNumber = cleanupString(registrationNumber);

          if (registrationNumber.equals("0"))
            break;

          if (!registrationNumber.matches("^[A-Z0-9]{2,7}$")) {
            registrationError = true;
            continue;
          }

          if(carExistsInGarage(registrationNumber)){
            registrationError = true;
            System.out.println("This car is already checked in.");
            continue;
          }

          CheckedCar cc = new CheckedCar(registrationNumber);
          checkedCars.add(cc);

          System.out.println("Thank you, your car " + registrationNumber + " is now checked in.");

          break;
        } // while option 1

        while (option.equals("2")) {
          if (checkedCars.size() == 0) {
            System.out.println("Your car is not registered, please register your car.\n");
            break;
          }

          if (registrationError) {
            System.out.println("You need to enter a valid registration number, A-Z and 0-9. Registration number must be " +
                    "of 2-7 characters and/or digits. \n" + "Please try again or enter \"0\" to Exit to Startpage.");
          } else {
            System.out.println("Please enter your registration number to check out, or enter \"0\" to Exit to Startpage.");
          }
          String registrationNumber = scan.nextLine();
          registrationNumber = registrationNumber.replace(" ", "").toUpperCase();

          if (registrationNumber.equals("0"))
            break;

          if (!registrationNumber.matches("^[A-Z0-9]{2,7}$")) {
            registrationError = true;
            continue;
          }

          if(!carExistsInGarage(registrationNumber)){
            registrationError = true;
            System.out.println("The car is not checked into the garage.");
            continue;
          }
          String checkout;
          checkout = getCheckoutOption(scan);

          int hours= 0;
          int days = 0;

          Boolean goBackToStart = false;
          while (checkout.equals("1")){
            System.out.println("Please enter how many hours you've been parked, or enter \"0\" to Exit to Startpage.");

            try {
              String tmp = scan.nextLine();
              hours = Integer.parseInt(tmp);
              if(hours == 0){
                goBackToStart = true;
                break;
              }
              if(hours < 1){
                System.out.println("Invalid parameter, number of hours can only be a positive amount. Please try again," +
                        " or enter \"0\" to Exit to Startpage.");
                continue;
              }
              break;
            } catch (Exception e){
              System.out.println("Invalid hours. Please try again or enter \"0\" to Exit to Startpage.");
            }

          }
          while (checkout.equals("2")) {
            System.out.println("Please enter how many days you've been parked, or enter \"0\" Exit to Startpage");
            try {
              String tmp = scan.nextLine();
              days = Integer.parseInt(tmp);
              if(days == 0){
                goBackToStart = true;
                break;
              }
              if(days < 1){
                System.out.println("Invalid parameter, number of days can only be a positive amount. Please try again, " +
                        "or enter \"0\" to Exit to Startpage.");
                continue;
              }
              break;
            } catch (Exception e) {
              System.out.println("Invalid days. Please try again or enter \"0\" to Exit to Startpage.");
            }
          }
          if (checkout.equals("0")) {
            break;
          }
          if(goBackToStart)
            break;

          int price = calculatePrice(hours, days);
          Boolean exitPaymentLoop = false;
          while(true) {
            System.out.println("The total price for your parking: " + price + " SEK");

            System.out.println("Which payment method would you like to use? \n" +
                    "1. Card Payment or 2. Invoice? \n" +
                    "To Exit to Startpage, enter \"0\" and press Enter.");

            System.out.println("Please enter your option:");
            String payment = scan.nextLine();
            Boolean goBackToPrevious = false;
            while (payment.equals("1")) {
              System.out.println("Please enter your card number, or enter \"0\" to  previous page.");
              String cardNr = scan.nextLine();

              cardNr = cleanupString(cardNr);
              if (cardNr.equals("0")) {
                goBackToPrevious = true;
                break;
              }
              if (!cardNr.matches("[0-9]{10}")) {
                System.out.println("The card number you entered is invalid, use only numbers between 0-9 an a maximum of" +
                        " 10 digits.");
                continue;
              }
              Card card = getCardFromCards(cardNr);

              if (card == null) {
                System.out.println("The card number you entered is invalid, use only numbers between 0-9 and a maximum of" +
                        " 10 digits. \n" + " Please try again or enter \"0\" to  previous page.");
                continue;
              }
              if (card.Blocked) {
                System.out.println("The card you're using is blocked, please enter another card or enter \"0\" to previous page.");
                continue;
              }
              if (card.Balance < price) {
                System.out.println("Denied payment, please enter another card or enter \"0\" to previous page.");
                continue;
              } else if (card.equals("0")) {
                break;
              }

              card.Balance -= price;
              removeCarFromGarage(registrationNumber);
              printReceipt(price, hours, days);
              exitPaymentLoop = true;
              break;
            }
            if (payment.equals("2")) {
              removeCarFromGarage(registrationNumber);
              printInvoice(price, hours, days);
              exitPaymentLoop = true;
              break;
            } else if (payment.equals("0")) {
              exitPaymentLoop = true;
              break;
            }

            if(goBackToPrevious || !payment.matches("[120]"))
              continue;

            break;
          }
          if(exitPaymentLoop)
            break;
        } //while option 2

        while (option.equals("3")) {
                        System.exit(0);
                      }

      } // while print menu
    } //print menu method

  private int calculatePrice(int hours, int days) {

    if(hours > 5){
      days = hours/24;
      if(hours % 24 != 0)
        days++;
      hours = 0;
    }
    return hours*10+days*50;
  }

  private String getCheckoutOption(Scanner scan) {
    String checkout;
    while(true){
      System.out.println("How long have you been parked? 1. Hours or 2. Days? \n" +
                  "To Exit to Startpage, enter \"0\" and press Enter.");
      System.out.println("Please enter your option:");

      checkout = scan.nextLine();
      if(checkout.matches("[120]")){
        break;
      }

    }
    return checkout;
  }

  private void printMainMenu() {
    printWelcome();
    printPrice();
    printVacancies();
    printMainMenuOptions();
  }

  private void printMainMenuOptions() {
    System.out.println("\n1. Would you like to check in you car?\n" +
            "2. Do you want to pay and exit the parking?\n" +
            "3. Terminate software");

    System.out.println("Please enter your option:");
  }

  private void printVacancies() {
    System.out.println("*   Number of vacancies: " + (15-checkedCars.size()) + " of 15   *");
    if(checkedCars.size() >= 15){
      System.out.println("* ParkGirl Garage is fully occupied! *");

    }
  }

  private void printReceipt(int price, int hours, int days) {
    if(hours != 0) {
      System.out.println("\n******* RECEIPT ******* \nThank you for your parking! \nHours: "+hours+" \nTotal: " + price + " SEK" +
              " \nHave a nice day and welcome back!\n \n");
    }
    else {
      System.out.println("\n******* RECEIPT ******* \nThank you for your parking! \nDays: "+days+" \nTotal: " + price + " SEK" +
              " \nHave a nice day and welcome back!\n \n");
    }
  }
  private void printInvoice(int price, int hours, int days) {
    if(hours != 0) {
      System.out.println("\n********* Invoice *********\nThank you for your parking, \nan invoice will be sent to your car address!" +
              "\nHours: " + hours + " \nTotal: " + price + " SEK \nHave a nice day and welcome back!\n \n");
    }
    else {
      System.out.println("\n********* Invoice *********\nThank you for your parking, \nan invoice will be sent to your car address!" +
              "\nDays: " + days + " \nTotal: " + price + " SEK \nHave a nice day and welcome back!\n \n");
    }
  }

  private void removeCarFromGarage(String registrationNumber) {
    for (CheckedCar car: checkedCars
         ) {
      if(car.RegistrationNumber.equals(registrationNumber)){
        checkedCars.remove(car);
        return;
      }
    }
  }
  private Boolean carExistsInGarage(String registrationNumber){
    for (CheckedCar car: checkedCars
         ) {
      if(car.RegistrationNumber.equals(registrationNumber))
        return true;
    }
    return false;
  }

  private Card getCardFromCards(String cardNr) {
    for (Card card: cards
    ) {
      if(card.CardNr.equals(cardNr)){
        return card;
      }
    }
    return null;
  }
} //class
