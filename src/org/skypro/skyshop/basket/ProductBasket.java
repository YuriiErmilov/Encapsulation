package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final String name;
    private final Product [] productBasket;
    private int size;

    public ProductBasket(String name) {
        this.name = name;
        productBasket = new Product[5];
        size = 0;
    }

    public String getName() {
        return name;
    }
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        if (size >= productBasket.length) {
            System.out.println(" Корзина переполнена ");
            return;
        }
        productBasket[size] = product;
        size++;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < size; i++) {
            totalPrice += productBasket[i].getPrice();
        }
        return totalPrice;
    }

    public void printInfoBasket() {
        System.out.println(getName());
        if  (size == 0) {
            System.out.println("Product Basket is null");
            return;
        }
        for (int i = 0; i < size; i++) {
            Product product = productBasket[i];
            System.out.println(" Название продукта " + product.getName() + ": " + product.getPrice() + " стоимостью ");
        }
        System.out.println("Итого : " + getTotalPrice());
    }

    public boolean hasProduct(String name) {
        if (name == null || size == 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Product product = productBasket[i];
            if ( product.getName().equalsIgnoreCase(name) ) {
                return true;
            }
        }
        return false;
    }

    public void cleatBasket() {
        for (int i = 0; i < size; i++) {
            productBasket[i] = null;
        }
        size = 0;
    }

}
