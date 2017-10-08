//Alessandro Baccin - 16724489

//The class Apartment will extend Property, adding 2 fields: storeyNumber and bedsNumber.
public class Apartment extends Property {
    //Fields
    private int storeyNumber;
    private int bedsNumber;
    //Constructor
    public Apartment(int registerNumber,
                     String ownerName,
                     String postalAddress,
                     int dailyRentalCost,
                     int rentalDays,
                     int storeysNumber,
                     int bedsNumber){
        super(registerNumber, ownerName, postalAddress, dailyRentalCost, rentalDays);//Invoking the superclass constructor.
        this.storeyNumber = storeysNumber;
        this.bedsNumber = bedsNumber;
    }

    //Default constructor.
    public Apartment(){
        super(0, "John Doe", "None", 0, 0);
        this.storeyNumber = 0;
        this.bedsNumber = 0;
    }

    //Accessors and Mutators methods.
    public void setStoreyNumber(int storeyNumber){ this.storeyNumber = storeyNumber; }

    public int getStoreyNumber(){ return this.storeyNumber; }

    public void setBedsNumber(int bedsNumber ){ this.bedsNumber = bedsNumber; }

    public int getBedsNumber(){ return this.bedsNumber; }

    //Method to return the class fields in a string format.
    @Override
    public String toString(){
        return String.format("%10s  |  Register number: %03d  |  Owner's name: %10s  |  Postal Address: %20s  |  Daily Rental Cost: %5d\u20ac  |  Season Rental days: %5d  |  Storey number: %5d  |  Beds number: %5d",getClass().getSimpleName(),getRegisterNumber(), getOwnerName(), getPostalAddress(),getDailyRentalCost(),getRentalDays(),getStoreyNumber(),getBedsNumber());
    }
}
