//Alessandro Baccin - 16724489

//The class Apartment will extend Property, adding 2 fields: storeyNumber and ClearingFees.
public class House extends Property {

    //Fields
    private int storeyNumber;
    private int clearingFees;

    //Constructor
    public House(int registerNumber,
            String ownerName,
            String postalAddress,
            int dailyRentalCost,
            int rentalDays,
            int storeysNumber,
            int clearingFees){
        super(registerNumber, ownerName, postalAddress, dailyRentalCost, rentalDays);//Invoking the superclass default constructor.
        this.storeyNumber = storeysNumber;
        this.clearingFees = clearingFees;
    }

    //Default constructor
    public House(){
        super(0, "John Doe", "None", 0, 0);
        this.storeyNumber = 0;
        this.clearingFees = 0;
    }

    //Accessors and Mutators methods.
    public void setStoreyNumber(int storeyNumber){ this.storeyNumber = storeyNumber; }

    public int getStoreyNumber(){
        return this.storeyNumber;
    }

    public void setClearingFees(int clearingFees){
        this.clearingFees = clearingFees;
    }

    public int getClearingFees(){ return this.clearingFees; }

    //Method to return the class fields in a string format.
    @Override
    public String toString(){
        return String.format("%10s    Register number: %03d  |  Owner's name: %10s  |  Postal address: %20s  |  Daily rental cost: %5d\u20ac  |  Season rental days: %5d  |  Storey number: %5d  |  Clearing fees: %5d\u20ac   ",getClass().getSimpleName(),getRegisterNumber(), getOwnerName(), getPostalAddress(),getDailyRentalCost(),getRentalDays(),getStoreyNumber(),getClearingFees());
    }
}
