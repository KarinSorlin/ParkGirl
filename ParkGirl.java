import java.util.Scanner;

public class ParkGirl{

  private void printWelcome(){
    System.out.println(" Welcome to ParkGirl garage! \n" +
                        "Our opening hours are 00.00-24.00, all week Monday to Sunday");
  }

  private void printPrice(){
    System.out.println(" Price option: \n" +
                        " 1 hour is 10 kr \n" +
                        " 4 hours is 40 kr \n" +
                        " 5-24 hours is 50 kr \n" +
                        " 2 days is 100 kr \n" +
                        " 2 weeks is 700 kr ");
  }

  private void printVacancies(){
    System.out.println(" Number of vacancies: ");
  }

  private void printMenu(){
    System.out.println("Select option:\n"+
                       "1. Would you like to check in you car?.\n"+
                       "2. Do you want to pay and exit the parking?.\n"+
                       "3. Terminate software.");
  }
public static void main(String[] args) {}

}
