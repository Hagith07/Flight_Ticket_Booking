public class Booking
{
    int pass_id;
    int ticket_no;
    int seats_required;
    String flight_name;
    double ticket_price;
    public Booking( int pass_id,int ticket_no,int seats_required,String flight_name,double ticket_price)
    {
        this.pass_id=pass_id;
        this.ticket_no=ticket_no;
        this.seats_required=seats_required;
        this.flight_name=flight_name;
        this.ticket_price=ticket_price;
    }
    static Booking booking[] = new Booking[100];
    static int booking_index =0;
    public static void ticket_booking(int id,int seats,String fli_name)
    {
        if(id>0 && id<=Passenger.passenger_index)
        {
            System.out.println("Welcome: "+Passenger.passenger[id-1].passenger_name);
            boolean x = true;
            int flag =0;
            int ticket_cost = 0;
            for (int i = 0; i < Flight.flight_index; i++)
            {
                if(Flight.flight[i].flight_name.equals(fli_name))
                {
                    x=false;
                    if(seats<= Flight.flight[i].seats)
                    {
                        for (int j = 0; j < seats; j++)
                        {
                            ticket_cost += Flight.flight[i].ticket_price;
                            Flight.flight[i].ticket_price += 200;
                        }
                        if(ticket_cost<=Passenger.passenger[id-1].balance)
                        {
                            System.out.println("Ticket Booked Successfully....");
                            Passenger.passenger[id-1].balance -= ticket_cost;
                            Flight.flight[i].seats -= seats;
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
                int pass_id = booking[tic_number - 1].pass_id;
                Passenger.passenger[pass_id - 1].balance += booking[tic_number - 1].ticket_price;
                Passenger.passenger[pass_id - 1].status = "cancelled";
                for (int i = 0; i < Flight.flight_index; i++) {
                    if (Flight.flight[i].flight_name.equals(booking[tic_number - 1].flight_name)) {
                        for (int j = 0; j < booking[tic_number - 1].seats_required; j++) {
                            Flight.flight[i].ticket_price -= 200;
                        }
                        Flight.flight[i].seats += booking[tic_number - 1].seats_required;
                    }

                }
            }
        else
        {
            System.out.println("Enter Valid Ticket Number");
        }
    }
}
