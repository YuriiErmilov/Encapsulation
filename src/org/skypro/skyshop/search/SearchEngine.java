package org.skypro.skyshop.search;
import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> items = new LinkedList<>() {
    };

    public void add(Searchable item){
        if (item != null) {
            items.add(item);
        }
    }

    public Map<String, Searchable> search(String query){
        Map<String, Searchable> results = new TreeMap();
        if (query == null || query.isBlank()){
                return results;
        }
        String lowerQuery = query.toLowerCase();
        for (Searchable item : items) {
            if (item.getSearchTerm().toLowerCase().contains(lowerQuery)) {
                results.put(item.getName(), item);
            }
        }
        return results;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        if  (search == null || search.isEmpty()){
            throw new BestResultNotFoundException(" Пусой поисковой запрос! ");
        }
        String searchLower = search.toLowerCase();
        Searchable best = null;
        int bestCount = 0;
        for (Searchable item : items) {
            int count = countOccurrences(item.getSearchTerm().toLowerCase(), searchLower);
            if (count > bestCount) {
                bestCount = count;
                best = item;
            }
        }
        if (best == null) {
            throw new BestResultNotFoundException(" Не найден результат для поискового запроса " + search);
        }
        return best;
    }
    private int countOccurrences(String text, String search){
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(search, index)) != -1) {
            count++;
            index += search.length();
        }
        return count;
    }

}
