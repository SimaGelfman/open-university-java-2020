package sima.gelfman.hm13;

import sima.gelfman.hm12.Date;
import sima.gelfman.hm12.FoodItem;

/**
 * Class Stock  represents a stock of a supermarket
 */
public class Stock implements IStock {
    private FoodItem[] _stock;
    private int _noOfItems;
    private static final int MAX_NO_OF_ITEMS = 100;

    public Stock() {

    }


    /**
     * gets number of items in a stock
     *
     * @return number of items
     */
    public int getNumOfItems() {
        return -1;
    }

    /**
     * Add new item to items array. Return true
     *
     * @param item
     * @return
     */

    public boolean addItem(FoodItem item) {
        return false;
    }


    public String order(int amount) {
        return null;
    }

    public int howMany(int temp) {
        return -1;
    }

    public void removeAfterDate(Date d) {

    }

    public FoodItem mostExpensive() {
        return null;
    }

    public int howManyPieces(){
        return -1;
    }

    public void updateStock(String[] itemsList){

    }

    public int getTempOfStock(){
        return -1;
    }

}
