package sima.gelfman.hm12;

public class FoodItem {
    // instance variables
    private final String _name;
    private final long _catalogueNumber;
    private int _quantity;
    private Date _productionDate;
    private Date _expiryDate;
    private final int _minTemperature;
    private final int _maxTemperature;
    private int _price;
    private static final String DEFAULT_NAME = "item";
    private static final long DEFAULT_CATALOG_NUMBER = 9999;
    private static final int DEFAULT_QUANTITY = 0;
    private static final int DEFAULT_PRICE = 1;
    private static final int DEFAULT_MIN_TEMPERATURE = -25;
    private static final int DEFAULT_MAX_TEMPERATURE = 30;

    /**
     * Constructs a new ProductItem with given params
     * When name is empty name = "item"
     * In case catalogueNumber less than 1000 or bigger then 9999 then catalogueNumber = 9999;
     * In case quantity < 0 quantity = 0;
     * In case productionDate the date after  expiryDate then expiryDate will be the next day of productionDate
     * In case minTemperature bigger then maxTemperature swap them
     * In case price is less then 0 the price will be 1;
     *
     * @param name            the name of the product
     * @param catalogueNumber the catalogue number
     * @param quantity        the quantity of the product
     * @param productionDate  the date when the item was produced
     * @param expiryDate      the date when the product is expired
     * @param minTemperature  minimum storage temperature
     * @param maxTemperature  maximum storage temperature
     * @param price           the price of the product
     */

    public FoodItem(String name, long catalogueNumber, int quantity, Date productionDate, Date expiryDate,
                    int minTemperature, int maxTemperature, int price) {
        //validate if the name is empty set default name
        if (name.equals(""))
            _name = DEFAULT_NAME;
        else _name = name;
        //validate catalog number
        if (catalogueNumber < 1000 || catalogueNumber > 9999)
            _catalogueNumber = DEFAULT_CATALOG_NUMBER;
        else _catalogueNumber = catalogueNumber;
        // validate if quantity less than 0 set default quantity
        if (quantity < 0)
            _quantity = DEFAULT_QUANTITY;
        _quantity = quantity;
        _productionDate = new Date(productionDate);
        //Validate expiry date bigger the production date
        _expiryDate = getValidExpiryDate(_productionDate, expiryDate);
        //validate maximum temperature bigger than minTemperature, if not swamp them
        if (minTemperature > maxTemperature) {
            _minTemperature = maxTemperature;
            _maxTemperature = minTemperature;
        } else {
            _minTemperature = minTemperature;
            _maxTemperature = maxTemperature;
        }
        //validate price > 0 if not set the default 1
        if (price <= 0)
            _price = DEFAULT_PRICE;
        else _price = price;
    }

    /**
     * Constructs a new FoodItem equivalent to the given FoodItem
     *
     * @param other
     */

    public FoodItem(FoodItem other) {
        // if not null copy object
        if (other != null) {
            _name = other._name;
            _catalogueNumber = other._catalogueNumber;
            _quantity = other._quantity;
            _productionDate = new Date(other._productionDate);
            _expiryDate = new Date(other._expiryDate);
            _minTemperature = other._minTemperature;
            _maxTemperature = other._maxTemperature;
            _price = other._price;
        }
        // if given object null set default
        else {
            _name = DEFAULT_NAME;
            _catalogueNumber = DEFAULT_CATALOG_NUMBER;
            _quantity = DEFAULT_QUANTITY;
            _productionDate = new Date(null); //null case is coverage in Date class
            _expiryDate = _productionDate.tomorrow();
            _minTemperature = DEFAULT_MIN_TEMPERATURE;
            _maxTemperature = DEFAULT_MAX_TEMPERATURE;
            _price = DEFAULT_PRICE;
        }


    }

    //getters and setters

    /**
     * gets the catalogue number
     *
     * @return the catalogue number
     */
    public long getCatalogueNumber() {
        return _catalogueNumber;
    }

    /**
     * gets the product name
     *
     * @return the name
     */

    public String getName() {
        return _name;
    }

    /**
     * gets the product quantity
     *
     * @return the quantity
     */

    public int getQuantity() {
        return _quantity;
    }

    /**
     * gets production date of the product
     *
     * @return the production date
     */

    public Date getProductionDate() {
        return _productionDate;
    }

    /**
     * gets expired date of the product
     *
     * @return the expired date
     */

    public Date getExpiryDate() {
        return _expiryDate;
    }

    /**
     * gets the minimum storage temperature of the product
     *
     * @return the minimum storage temperature
     */
    public int getMinTemperature() {
        return _minTemperature;
    }

    /**
     * gets the maximum storage temperature of the product
     *
     * @return maximum storage temperature
     */

    public int getMaxTemperature() {
        return _maxTemperature;
    }

    /**
     * gets the product price
     *
     * @return the price
     */
    public int getPrice() {
        return _price;
    }

    /**
     * set the expiry date (only if not before production date )
     *
     * @param d expiry date value to be set
     */

    public void setExpiryDate(Date d) {
        if (d != null)
            _expiryDate = getValidExpiryDate(_productionDate, d);
    }

    /**
     * set the price (only if positive)
     *
     * @param price price value to be set
     */

    public void setPrice(int price) {
        if (price > 0)
            _price = price;
    }

    /**
     * set the production date (only if not after expiry date )
     *
     * @param d
     */

    public void setProductionDate(Date d) {
        if (d != null || d.before(_expiryDate))
            _productionDate = new Date(d);
    }

    /**
     * set the quantity (only if not negative)
     *
     * @param quantity
     */

    public void setQuantity(int quantity) {
        if (quantity >= 0)
            _quantity = quantity;

    }


    //Methods

    /**
     * validate if production date before expiry date
     *
     * @param productionDate
     * @param expiryDate
     * @return true whe production date before expiry date
     */

    private static Date getValidExpiryDate(Date productionDate, Date expiryDate) {
        if (productionDate.before(expiryDate))
            return new Date(expiryDate);
        return productionDate.tomorrow();
    }

    /**
     * check if 2 food items are the same (excluding the quantity values)
     *
     * @param other the food item to compare this food item to
     * @return true if the food items are the same
     */
    public boolean equals(FoodItem other) {
        if (other == null)
            return false;
        if (_name.equals(other._name) && _catalogueNumber == other._catalogueNumber && _productionDate.equals(other._productionDate) &&
                _expiryDate.equals(other._expiryDate) && _minTemperature == other._minTemperature && _maxTemperature == other._maxTemperature
                && _price == other._price)
            return true;
        return false;
    }

    /**
     * returns a String that represents this food item
     *
     * @return String that represents this food item in the following format:
     * FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3
     */
    public String toString() {
        return "FoodItem: " + _name + "\t"
                + "CatalogueNumber: " + _catalogueNumber + "\t"
                + "ProductionDate: " + _productionDate.toString() + "\t"
                + "ExpiryDate: " + _expiryDate.toString() + "\t"
                + "Quantity: " + _quantity;
    }

    /**
     * check if this food item is older than other food item
     *
     * @param other food item to compare this food item to
     * @return true if this food item is older than other date
     */
    public boolean olderFoodItem(FoodItem other) {
        return _productionDate.before(other.getProductionDate());
    }

    /**
     * check if this food item is fresh on the date d
     *
     * @param d date to check
     * @return
     */

    public boolean isFresh(Date d) {
        if (d == null)
            return false;
        return d.before(_expiryDate);
    }

    /**
     * returns the number of units of products that can be purchased for a given amount
     * if the quantity of the item less the purchased for a given amount the method returns the quantity
     *
     * @param amount amount to purchase
     * @returnthe number of units can be purchased
     */

    public int howManyItems(int amount) {
        int numberPurchasedItems = amount / _price;
        if (numberPurchasedItems < _quantity)
            return numberPurchasedItems;
        return _quantity;
    }

    /**
     * check if this food item is cheaper than other food item
     *
     * @param other food item to compare this food item to
     * @return true if this food item is cheaper than other one
     */
    public boolean isCheaper(FoodItem other) {
        if (other == null)
            return false;
        if (_price < other._price)
            return true;
        return false;
    }


}
