//Alessandro Baccin - 16724489

//This class will be inherited by the classes Apartment, House and Villa.
//It provides the common fields that define a property.
public class Property {

    //Fields
    private int registerNumber;
    private String ownerName;
    private String postalAddress;
    private int dailyRentalCost;
    private int rentalDays;

    //Constructor
    public Property(int registerNumber, String ownerName, String postalAddress, int dailyRentalCost, int rentalDays){
        this.registerNumber = registerNumber;
        this.ownerName = ownerName;
        this.postalAddress = postalAddress;
        this.dailyRentalCost = dailyRentalCost;
        this.rentalDays = rentalDays;
    }

    //Default constructor
    public Property(){
        this.registerNumber = 0;
        this.ownerName = "John Doe";
        this.postalAddress = "None";
        this.dailyRentalCost = 0;
        this.rentalDays = 0;
    }

    //Method to increment the number of RentalDays.
    public void rentProperty(int days){ this.rentalDays += days; }

    //Accessors and Mutators methods.
    public void setRegisterNumber(int registerNumber){
        this.registerNumber = registerNumber;
    }

    public int getRegisterNumber() { return this.registerNumber; }

    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }

    public String getOwnerName(){
        return this.ownerName;
    }

    public void setPostalAddress(String postalAddress){
        this. postalAddress = postalAddress;
    }

    public String getPostalAddress(){ return this.postalAddress; }

    public void setDailyRentalCost(int dailyRentalCost){
        this.dailyRentalCost = dailyRentalCost;
    }

    public int getDailyRentalCost(){
        return this.dailyRentalCost;
    }

    public void setRentalDays(int rentalDays){
        this.rentalDays = rentalDays;
    }

    public int getRentalDays(){ return this.rentalDays;
    }
}
