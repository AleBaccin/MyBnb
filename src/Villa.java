//Alessandro Baccin - 16724489

//The class Apartment will extend Property, adding 3 fields: rooms, roomServiceCost and luxuryTaxPerDay.
public class Villa extends Property {

    //Fields
    private int rooms;
    private int roomServiceCost;
    private int luxuryCostPerDay;

    //Constructor
    public Villa(int registerNumber,
                 String ownerName,
                 String postalAddress,
                 int dailyRentalCost,
                 int rentalDays,
                 int rooms,
                 int roomServiceCost,
                 int luxuryCostPerDay){
        super(registerNumber, ownerName, postalAddress,dailyRentalCost, rentalDays);//Invoking the superclass constructor
        this.rooms = rooms;
        this.roomServiceCost = roomServiceCost;
        this.luxuryCostPerDay = luxuryCostPerDay;
    }

        //Default constructor.
    public Villa(){
        super(0, "John Doe", "None", 0, 0);
        this.rooms = 0;
        this.roomServiceCost = 0;
        this.luxuryCostPerDay = 0;
    }

    //Accessors and Mutators methods.
    public void setRooms(int rooms){
        this.rooms = rooms;
    }

    public int getRooms(){ return this.rooms; }

    public void setRoomServiceCost(int roomServiceCost){
        this.roomServiceCost = roomServiceCost;
    }

    public int getRoomSeriveCost(){
        return this.roomServiceCost;
    }

    public void setLuxuryCostPerDay(int luxuryCostPerDay){
        this.luxuryCostPerDay = luxuryCostPerDay;
    }

    public int getLuxuryCostPerDay(){
        return this.luxuryCostPerDay;
    }

    //Method to return the class fields in a string format.
    @Override
    public String toString(){
        return String.format("%10s    Register number: %03d  |  Owner's name: %10s  |  Postal address: %20s  |  Daily rental cost: %5d\u20ac  |  Season rental days: %5d  |  Rooms: %5d  |  Rooms service cost: %5d\u20ac  |  Luxury tax per day: %5d\u20ac",getClass().getSimpleName(),getRegisterNumber(), getOwnerName(), getPostalAddress(),getDailyRentalCost(),getRentalDays(),getRooms(),getRoomSeriveCost(),getLuxuryCostPerDay());
    }
}
