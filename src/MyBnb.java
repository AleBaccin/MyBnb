//Alessandro Baccin - 16724489

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

@SuppressWarnings("unchecked")

public class MyBnb {
    //Initializing the 3 Arraylist as global variables.
    private ArrayList<Apartment> apartments = new ArrayList<Apartment>();
    private ArrayList<House> houses = new ArrayList<House>();
    private ArrayList<Villa> villas = new ArrayList<Villa>();

    //This method will check if the register number is already present in the arraylist, if it is it will generate a new regNumb.
    private int generateUniqueRegNumber(ArrayList<Property> properties, int regNumb){
        //This method will check if the register number is already present in the arraylist, if it is it will generate a new regNumb.
        Random rdn = new Random();
        for (int c = 0; c < properties.size(); c++) {
            if(regNumb == properties.get(c).getRegisterNumber())
                regNumb = rdn.nextInt(999)+1; //The register number will be from 100 to 999.
        }
        return regNumb;
    }
    //The 3 methods fillInApartments, fillInHouses and fillInVillas are used to populate the global arrayLists with
    //random values, as the description state, we will add 3 objects in each Arraylist.
    private void fillInApartments() {
        Random rdn = new Random();
        for(int c = 0; c < 3; c++){
            int dailyRentalCost = rdn.nextInt(30+1)+20;   //Daily Rental cost Between 20 and 50.
            int regNumb = rdn.nextInt(999)+1;

            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) houses, regNumb);
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) villas, regNumb);
            Apartment apt = new Apartment(regNumb,
                    "Ale"+c,
                    20 + c + " Jump Street",
                    dailyRentalCost,
                    0,
                    1,
                    1);
            apartments.add(apt);
        }
    }

    private void fillInHouses(){
        Random rdn = new Random();
        for(int c = 0; c < 3; c++){
            int dailyRentalCost = rdn.nextInt(30+1) + 50;   //Daily Rental Cost Between 50 and 80
            int clearingFees =  rdn.nextInt(10 + 1) + 10;   //Clearing Fees Between 10 and 20
            int regNumb = rdn.nextInt(999)+1;
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) apartments, regNumb);
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) houses, regNumb);
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) villas, regNumb);
            House hou = new House(regNumb,
                    "Will"+c,
                    50 + c +" Jump Street",
                    dailyRentalCost,
                    0,
                    1,
                    clearingFees);
            houses.add(hou);
        }
    }

    private void fillInVillas(){
        Random rdn = new Random();
        for(int c = 0; c < 3; c++){
            int dailyRentalCost = rdn.nextInt(50+1) + 100;   //Daily Rental Cost Between 100 and 150
            int luxuryServiceCost =  rdn.nextInt(10 + 1) + 10;   //Clearing Fees Between 10 and 20
            int roomServiceCost =  rdn.nextInt(10 + 1) + 15;   //Clearing Fees Between 15 and 25
            int regNumb = rdn.nextInt(999)+1;
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) apartments, regNumb);
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) houses, regNumb);
            regNumb = generateUniqueRegNumber((ArrayList<Property>)(ArrayList<?>) villas, regNumb);
            Villa vi = new Villa(regNumb,
                    "Mat"+c,
                    80 + c +" Jump Street",
                    dailyRentalCost,
                    0,
                    5,
                    roomServiceCost,
                    luxuryServiceCost);
            villas.add(vi);
       }
    }

    //This method will be called in the main method, in order to populate the Arraylist. We will then use the method
    //rentProperties on each Arraylist in order to update the RentalDays instance, simulating a booking process.
    public void fillInProperties(){
        fillInApartments();
        fillInHouses();
        fillInVillas();
        rentProperties((ArrayList<Property>)(ArrayList<?>) apartments, 3);
        rentProperties((ArrayList<Property>)(ArrayList<?>) houses, 3);
        rentProperties((ArrayList<Property>)(ArrayList<?>) villas, 3);
    }

    //This method will increment the instance RentalDays on each property with random values.
    private void rentProperties(ArrayList<Property> properties, int nTimes) {
        Random rnd = new Random();
        for(Property prop : properties){
            for(int c = 0; c < nTimes; c++) {
                prop.rentProperty(rnd.nextInt(10)+1);
            }
        }
    }

    //This method will call dumpProperty for each object Property present in the Arraylist properties.
    private String dumpProperties(ArrayList<Property> properties){
        String result = "";
        for (Property prop: properties)
            result +=dumpProperty(prop) + "\n";
        return result;
    }

    //This method will call the method toString present in the subclasses of Property.
    private String dumpProperty(Property prop) {
        return prop.toString();
    }
    //This method will call dumpProperties for each of the Arraylists declared above.
    public void printAllProperties(){
        JOptionPane.showMessageDialog(null,
                dumpProperties((ArrayList<Property>)(ArrayList<?>) apartments)+"\n"+
                        dumpProperties((ArrayList<Property>)(ArrayList<?>) houses)+"\n"+
                        dumpProperties((ArrayList<Property>)(ArrayList<?>) villas));
    }

    //This method will calculate the income for a single Arraylist.
    // without any of the ExtraServices (e.g. Clearing fees...).
    public int totalRentIncome(ArrayList<Property> properties){
        int result = 0;
        for (Property prop: properties)
            result += prop.getRentalDays() * prop.getDailyRentalCost();
        return result;
    }

    //We will then use the method totalRentMethod on each of the Arraylist, to then calculate the income from the extra services.
    //The 2 values income and extraServices will then be summed.
    public double calculateTotalIncome(){
        int income = 0;
        income += totalRentIncome((ArrayList<Property>)(ArrayList<?>) apartments);
        income += totalRentIncome((ArrayList<Property>)(ArrayList<?>) houses);
        income += totalRentIncome((ArrayList<Property>)(ArrayList<?>) villas);

        int extraServices = 0;           //The variable extraServices has been created to differentiate the 2 incomes the "basic" one, from the rents and the extra one from all the other charges

        for (House hou: houses)
            extraServices += hou.getClearingFees();

        for (Villa vi: villas)
            extraServices += vi.getRoomSeriveCost() * vi.getRentalDays() + vi.getLuxuryCostPerDay() * vi.getRentalDays();

        income += extraServices;

        String result = String.format("Total Income: %d\u20ac, of which %d\u20ac from Extra Services", income, extraServices);

        JOptionPane.showMessageDialog(null, result);

        return income;
    }

    public static void main(String[] args){
        MyBnb start = new MyBnb();
        start.fillInProperties();
        start.printAllProperties();
        start.calculateTotalIncome();

        System.exit(0);
    }
}

