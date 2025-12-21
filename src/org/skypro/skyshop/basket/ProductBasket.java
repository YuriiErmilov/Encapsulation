package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final String name;
    private final Map<String, List<Product>> products = new HashMap<>();

    public ProductBasket(String name) {
        this.name = name;
    }

    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);
    }

    public boolean hasProduct(String name) {
        return name != null && products.containsKey(name);
    }

    public List<Product> removeProductsByName(String name) {
        if (name == null) {
            return List.of();
        }
        List<Product> removed = products.remove(name);
        return removed == null ? List.of() : removed;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    public void printInfoBasket() {
        System.out.println(getName());
        int specialCount = 0;
        if (products.isEmpty()) {
            System.out.println("Product Basket is null");
            return;
        }
        for (List<Product> productList : products.values()) {
            for (Product product : productList) {
                System.out.println(product);
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого : " + getTotalPrice());
        System.out.println(" Специальных товаров: " + specialCount);
    }

    public String getName() {
        return name;
    }


    public void cleatBasket() {
        products.clear();
    }
}


