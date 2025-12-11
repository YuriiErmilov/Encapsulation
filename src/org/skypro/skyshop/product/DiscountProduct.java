package org.skypro.skyshop.product;

public class DiscountProduct extends Product {
    private final int basePrice;
    private final int discount;

    public DiscountProduct(String name, int price, int discount) {
        super(name);
        if (discount <= 0 || discount > 100) {
            throw new IllegalArgumentException("Discount must be between 0 and 100");
        }
        this.basePrice = price;
        this.discount = discount;
    }
    @Override
    public int getPrice() {
        return basePrice * (100 -  discount) / 100;
    }
    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return " Название : " + getName() + " : " + getPrice() + " ( скидка " +  discount + " %)";
    }



}
