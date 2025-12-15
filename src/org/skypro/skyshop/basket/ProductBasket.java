package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {
    private final String name;
    private final List<Product> products;

    public ProductBasket(String name) {
        this.name = name;
        this.products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public void printInfoBasket() {
        System.out.println(getName());
        int specialCount = 0;
        if  (products.isEmpty()) {
            System.out.println("Product Basket is null");
            return;
        }
        for (Product product : products) {
            System.out.println(product);
            if (product.isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого : " + getTotalPrice());
        System.out.println(" Специальных товаров: " + specialCount);
    }

    public boolean hasProduct(String name) {
        if (name == null) {
            return false;
        }
        for (Product product : products) {
            if ( product.getName().equalsIgnoreCase(name) ) {
                return true;
            }
        }
        return false;
    }

    public void cleatBasket() {
        products.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removed = new ArrayList<>();
        if(name == null) {
        return removed;
    }
        for (int i = products.size() - 1; i >= 0; i--) {
            Product product = products.get(i);
            if (product.getName().equalsIgnoreCase(name)) {
                removed.add(product);
                products.remove(i);
            }
        }
        return removed;
    }
}
