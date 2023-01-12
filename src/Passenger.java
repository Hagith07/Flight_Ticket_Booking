public class Passenger
{
    private int passenger_id;
    private String passenger_name;
    private int age;
    private double balance;
    private String status;
    public Passenger(int passenger_id,String passenger_name,int age,double balance,String status)
    {
        this.setPassenger_id(passenger_id);
        this.setPassenger_name(passenger_name);
        this.setAge(age);
        this.setBalance(balance);
        this.setStatus(status);
    }
    static Passenger passenger[] = new Passenger[100];
    static int passenger_index =0;
    public static void passenger_creation(String name,int age,double balance)
    {
        passenger[passenger_index] = new Passenger(passenger_index++,name,age,balance,"Booked");
        System.out.println("Passenger created");
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
