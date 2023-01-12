public class Passenger
{
    int passenger_id;
    String passenger_name;
    int age;
    double balance;
    String status;
    public Passenger(int passenger_id,String passenger_name,int age,double balance,String status)
    {
        this.passenger_id=passenger_id;
        this.passenger_name=passenger_name;
        this.age=age;
        this.balance=balance;
        this.status = status;
    }
    static Passenger passenger[] = new Passenger[100];
    static int passenger_index =0;
    public static void passenger_creation(String name,int age,double balance)
    {
        passenger[passenger_index] = new Passenger(passenger_index++,name,age,balance,"Booked");
        System.out.println("Passenger created");
    }
}
