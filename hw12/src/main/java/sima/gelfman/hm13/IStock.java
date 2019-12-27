package sima.gelfman.hm13;

import sima.gelfman.hm12.Date;
import sima.gelfman.hm12.FoodItem;

public interface IStock {
    boolean addItem(FoodItem newItem);

    int getNumOfItems();

    String order(int amount);

    int howMany(int temp);

    void removeAfterDate(Date d);

    FoodItem mostExpensive();

    int howManyPieces();

    void updateStock(String[] itemsList);

    int getTempOfStock();
}
