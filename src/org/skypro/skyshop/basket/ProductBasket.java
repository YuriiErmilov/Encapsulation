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
        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }

    public void printInfoBasket() {
        System.out.println(getName());
        if (products.isEmpty()) {
            System.out.println("Product Basket is null");
            return;
        }
       products.values().stream().flatMap(Collection::stream).forEach(System.out::println);
        System.out.println("Итого : " + getTotalPrice());
        System.out.println(" Специальных товаров: " + getSpecialCount());
    }

    private long getSpecialCount() {
        return products.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();
    }

    public String getName() {
        return name;
    }


    public void cleatBasket() {
        products.clear();
    }
}


