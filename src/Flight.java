public class Flight
{
    int seats = 50;
    String flight_name;
    int flight_number;
    int ticket_price = 5000;
    public Flight(String flight_name,int flight_number)
    {
        this.flight_name = flight_name;
        this.flight_number=flight_number;
    }
    static Flight flight[] = new Flight[100];
    static int flight_index = 0;
    public static void flight_creation(String flight_name)
    {
        flight[flight_index] = new Flight(flight_name,flight_index++);
        System.out.println("FLIGHT CREATED");
    }
    public static void print_flight_details(int fli_number)
    {
        System.out.println("Flight Details: \nName: "+flight[fli_number-1].flight_name+"\nNumber of seats available: "+flight[fli_number-1].seats+"\nPrice of the ticket: "+flight[fli_number-1].ticket_price);
        System.out.println("------------------------------------------------------------------");
        System.out.println("Passenger Details: ");
        for (int i = 0; i < Passenger.passenger_index; i++)
        {
            if(flight[fli_number-1].flight_name.equals(Booking.booking[i].flight_name))
            {
                int pass_id = Booking.booking[i].pass_id-1;
                if(Passenger.passenger[pass_id].status != "cancelled")
                {
                    System.out.println("Passenger's ID: "+Passenger.passenger[pass_id].passenger_id);
                    System.out.println("Passenger's name: " + Passenger.passenger[pass_id].passenger_name);
                    System.out.println("Passenger's age: " + Passenger.passenger[pass_id].age);
                    System.out.println("Passenger's balance: " + Passenger.passenger[pass_id].balance);
                    System.out.println("Number of seats booked: "+Booking.booking[i].seats_required);
                    System.out.println("-----------------------------------------------------------");
                }
            }
        }
    }
}
