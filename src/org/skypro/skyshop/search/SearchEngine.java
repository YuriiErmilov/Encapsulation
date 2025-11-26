package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] items;
    private int size;

    public SearchEngine(int capacity) {
        items = new Searchable[capacity];
        size = 0;
    }
    public void add(Searchable item){
        if (item == null || size == items.length) {
            return;
        }
        items[size] = item;
        size++;
    }

    public Searchable[] search(String query){
        Searchable[] results = new Searchable[5];
        int found = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[found] = items[i];
                found++;
                if (found == 5) {
                    break;
                }
            }
        }
        return results;
    }

}
