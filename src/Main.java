import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to flight ticket booking: ");
        while (true)
        {
            System.out.print("Enter your choice\n1-Flight Creation\n2-Passenger Creation\n3-Booking\n4-Cancel Ticket\n5-Print Flight Details: \n");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter the Flight's name: ");
                    String flight_name = sc.next();
                    Flight.flight_creation(flight_name);
                    break;
                case 2:
                    System.out.println("Enter your name: ");
                    String name = sc.next();
                    System.out.println("Enter your age: ");
                    int age = sc.nextInt();
                    System.out.println("Enter your balance: ");
                    double balance = sc.nextDouble();
                    Passenger.passenger_creation(name,age,balance);
                    break;
                case 3:
                    System.out.println("Enter your ID: ");
                    int id = sc.nextInt();
                    System.out.println("Enter number of seats required: ");
                    int seats = sc.nextInt();
                    System.out.println("Enter the name of your flight you want to travel: ");
                    String fli_name = sc.next();
                    Booking.ticket_booking(id,seats,fli_name);
                    break;
                case 4:
                    System.out.println("Enter your ticket number: ");
                    int tic_number = sc.nextInt();
                    Booking.ticket_cancelling(tic_number);
                    break;
                case 5:
                    System.out.println("Enter your flight number: ");
                    int fli_number = sc.nextInt();
                    Flight.print_flight_details(fli_number);
                    break;
            }
        }
    }
}