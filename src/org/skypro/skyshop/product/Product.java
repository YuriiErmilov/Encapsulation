package org.skypro.skyshop.product;
import org.skypro.skyshop.search.Searchable ;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    @Override
    public String getSearchTerm(){
        return name;
    }
    @Override
    public String getSearchableType(){
        return "PRODUCT";
    }
    @Override
    public String getName() {
        return name;
    }

    public abstract int getPrice();


    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return " Название : " + name + " : " + getPrice();
    }





}
