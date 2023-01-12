public class Flight
{
    private int seats = 50;
    private String flight_name;
    private int flight_number;
    private int ticket_price = 5000;
    public Flight(String flight_name,int flight_number)
    {
        this.setFlight_name(flight_name);
        this.setFlight_number(flight_number);
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
        System.out.println("Flight Details: \nName: "+ flight[fli_number - 1].getFlight_name() +"\nNumber of seats available: "+ flight[fli_number - 1].getSeats() +"\nPrice of the ticket: "+ flight[fli_number - 1].getTicket_price());
        System.out.println("------------------------------------------------------------------");
        System.out.println("Passenger Details: ");
        for (int i = 0; i < Passenger.passenger_index; i++)
        {
            if(flight[fli_number - 1].getFlight_name().equals(Booking.booking[i].getFlight_name()))
            {
                int pass_id = Booking.booking[i].getPass_id() -1;
                if(Passenger.passenger[pass_id].getStatus() != "cancelled")
                {
                    System.out.println("Passenger's ID: "+ Passenger.passenger[pass_id].getPassenger_id());
                    System.out.println("Passenger's name: " + Passenger.passenger[pass_id].getPassenger_name());
                    System.out.println("Passenger's age: " + Passenger.passenger[pass_id].getAge());
                    System.out.println("Passenger's balance: " + Passenger.passenger[pass_id].getBalance());
                    System.out.println("Number of seats booked: "+ Booking.booking[i].getSeats_required());
                    System.out.println("-----------------------------------------------------------");
                }
            }
        }
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public int getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(int flight_number) {
        this.flight_number = flight_number;
    }

    public int getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(int ticket_price) {
        this.ticket_price = ticket_price;
    }
}
