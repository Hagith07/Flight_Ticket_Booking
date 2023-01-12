public class Booking
{
    private int pass_id;
    private int ticket_no;
    private int seats_required;
    private String flight_name;
    private double ticket_price;
    public Booking( int pass_id,int ticket_no,int seats_required,String flight_name,double ticket_price)
    {
        this.setPass_id(pass_id);
        this.setTicket_no(ticket_no);
        this.setSeats_required(seats_required);
        this.setFlight_name(flight_name);
        this.setTicket_price(ticket_price);
    }
    static Booking booking[] = new Booking[100];
    static int booking_index =0;
    public static void ticket_booking(int id,int seats,String fli_name)
    {
        if(id>0 && id<=Passenger.passenger_index)
        {
            System.out.println("Welcome: "+ Passenger.passenger[id - 1].getPassenger_name());
            boolean x = true;
            int flag =0;
            int ticket_cost = 0;
            for (int i = 0; i < Flight.flight_index; i++)
            {
                if(Flight.flight[i].getFlight_name().equals(fli_name))
                {
                    x=false;
                    if(seats<= Flight.flight[i].getSeats())
                    {
                        for (int j = 0; j < seats; j++)
                        {
                            ticket_cost += Flight.flight[i].getTicket_price();
                            Flight.flight[i].setTicket_price(Flight.flight[i].getTicket_price() + 200);
                        }
                        if(ticket_cost<= Passenger.passenger[id - 1].getBalance())
                        {
                            System.out.println("Ticket Booked Successfully....");
                            Passenger.passenger[id - 1].setBalance(Passenger.passenger[id - 1].getBalance() - ticket_cost);
                            Flight.flight[i].setSeats(Flight.flight[i].getSeats() - seats);
                        }
                        else
                        {
                            System.out.println("Not enough Balance......");
                            flag =1;
                        }
                    }
                    else
                    {
                        System.out.println("Sorry no seats are available: ");
                        flag =1;
                    }
                    break;
                }
            }
            if(flag == 0)
            {
                booking[booking_index] = new Booking(id,booking_index++,seats,fli_name,ticket_cost);
            }
            if(x)
            {
                System.out.println("The Flight you were searching was not found: ");
            }
        }
        else
        {
            System.out.println("Enter valid ID: ");
        }
    }
    public static void ticket_cancelling(int tic_number)
    {
        if(tic_number>0&&tic_number<=booking_index)
        {
                System.out.println("Ticket Cancelled Successfully.....");
                int pass_id = booking[tic_number - 1].getPass_id();
                Passenger.passenger[pass_id - 1].setBalance(Passenger.passenger[pass_id - 1].getBalance() + booking[tic_number - 1].getTicket_price());
                Passenger.passenger[pass_id - 1].setStatus("cancelled");
                for (int i = 0; i < Flight.flight_index; i++) {
                    if (Flight.flight[i].getFlight_name().equals(booking[tic_number - 1].getFlight_name())) {
                        for (int j = 0; j < booking[tic_number - 1].getSeats_required(); j++) {
                            Flight.flight[i].setTicket_price(Flight.flight[i].getTicket_price() - 200);
                        }
                        Flight.flight[i].setSeats(Flight.flight[i].getSeats() + booking[tic_number - 1].getSeats_required());
                    }

                }
            }
        else
        {
            System.out.println("Enter Valid Ticket Number");
        }
    }

    public int getPass_id() {
        return pass_id;
    }

    public void setPass_id(int pass_id) {
        this.pass_id = pass_id;
    }

    public int getTicket_no() {
        return ticket_no;
    }

    public void setTicket_no(int ticket_no) {
        this.ticket_no = ticket_no;
    }

    public int getSeats_required() {
        return seats_required;
    }

    public void setSeats_required(int seats_required) {
        this.seats_required = seats_required;
    }

    public String getFlight_name() {
        return flight_name;
    }

    public void setFlight_name(String flight_name) {
        this.flight_name = flight_name;
    }

    public double getTicket_price() {
        return ticket_price;
    }

    public void setTicket_price(double ticket_price) {
        this.ticket_price = ticket_price;
    }
}
