package repository;

import model.Bike;

import java.util.ArrayList;
import java.util.List;

public class BikeRepository {

    List<Bike> bikes;

    public BikeRepository() {

        bikes = new ArrayList<Bike>();

        bikes.add(new Bike(1, "KTM RC 8", "1129", 278, 25.8));

        bikes.add(new Bike(2, "Yamaha R1", "999", 299, 22.5));

        bikes.add(new Bike(3, "BMW S1000 RR", "1000", 295, 32.5));

        bikes.add(new Bike(4, "Kawasaki Ninja ZX-10R", "1010", 299, 18.7));

        bikes.add(new Bike(5, "Ducati Monster 999", "1000", 294, 20.5));
    }

    public List<Bike> getAllBikes() {

        return bikes;
    }

    public boolean addBikes(Bike b) {

        //using arraylist (collections) predefined methods to perform crud  operations
        bikes.add(b);
        return true;
    }

    public boolean deleteBikes(int bike_id) {
        //object of Bike type formed to store if any record matches with passed bike_id
        Bike bt = null;

        //running enhanced for loop on all 5 records with using variable 'b'
        for (Bike b : bikes) {
            //checking each records id with arguement passed
            //and if record matches by id then storing the matched object into bt object
            if (b.getBike_id() == bike_id) {
                bt = b;
                break;
            }
        }
        //if bt object is populated by any matched record then delete it using arraylist method and return true
        if (bt != null) {
            bikes.remove(bt);
            return true;

        }
        //else return false
        return false;
    }

    public Bike getbikebyId(int bike_id) {
        //object of Bike type formed to store if any record matches with passed bike_id
        Bike bt = null;
        //running enhanced for loop on all 5 records with using variable 'b'
        for (Bike b : bikes) {
            //checking each records id with arguement passed
            //and if record matches by id then storing the matched object into bt object
            if (b.getBike_id() == bike_id) {
                bt = b;
                break;
            }
        }
        //returning populated bt object.
        return bt;
    }

    public boolean updateRecord(Bike bt){
        //running enhanced for loop on all 5 records with using variable 'b'
        for(Bike b:bikes)
        {
            //checking each records id with arguement passed
            if(b.getBike_id()==bt.getBike_id())
                {
                 //if matched then setting the attribute values or updating it.
                b.setBike_id(bt.getBike_id());
                b.setBike_name(bt.getBike_name());
                b.setBike_engine_capacity(bt.getBike_engine_capacity());
                b.setBike_top_speed(bt.getBike_top_speed());
                b.setBike_price(bt.getBike_price());
                break;
            }
        }
        return true;
    }

}
