package sima.gelfman.hm13;

import sima.gelfman.hm12.Date;
import sima.gelfman.hm12.FoodItem;

public class StockTest {
    private static <T> void ensure(String requirement, T actual, T expected) {
        boolean valid = actual == expected;
        if (valid) {
            System.out.println("[ PASSED ]  " + requirement);
        } else {
            System.err.println("[ FAILED ]  " + requirement + ": expected `" + expected + "` but got `" + actual + "`");
        }
    }

    public static void main(String[] args) {
        {
            IStock stock = new Stock();
            ensure("Stock should be initially empty", stock.getNumOfItems(), 0);
        }
        {
            IStock stock = new Stock();
            FoodItem foodItem = new FoodItem("Pork", 1408, 20, new Date(1, 1, 2019), new Date(1, 2, 2018), 2, 6, 100);
            ensure("Item should be added to stock", stock.addItem(foodItem), true);
            ensure("It should be the only item", stock.getNumOfItems(), 1);
        }
        {
            IStock stock = new Stock();
            int quantity = 20;
            FoodItem foodItem = new FoodItem("Pork", 1408, quantity, new Date(1, 1, 2019), new Date(1, 2, 2018), 2, 6, 100);
            stock.addItem(foodItem);
            ensure("It should provide number of pieces", stock.howManyPieces(), quantity);
        }
        {
            IStock stock = new Stock();
            int quantity = 20;
            FoodItem foodItem = new FoodItem("Pork", 1408, quantity, new Date(1, 1, 2019), new Date(1, 2, 2018), 2, 6, 100);
            stock.addItem(foodItem);

            FoodItem additionalFoodItem = new FoodItem(foodItem);
            int additionalQuantity = 30;
            additionalFoodItem.setQuantity(additionalQuantity);
            ensure("Additional item should be added to stock", stock.addItem(additionalFoodItem), true);
            ensure("It should increase pieces quantity", stock.howManyPieces(), quantity + additionalQuantity);
            ensure("It should not increase number of items", stock.getNumOfItems(), 1);
        }
    }
}
