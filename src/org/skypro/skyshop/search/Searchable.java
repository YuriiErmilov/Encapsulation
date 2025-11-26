package org.skypro.skyshop.search;

public interface Searchable {

    String  getSearchTerm();
    String  getSearchableType();
    String  getName();
    default String  getStringRepresentation(){
        return  getName() + " - " + getSearchTerm();
    }
}
