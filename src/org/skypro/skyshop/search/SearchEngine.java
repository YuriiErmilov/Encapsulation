package org.skypro.skyshop.search;
import org.skypro.skyshop.exception.BestResultNotFoundException;

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

    public Searchable findBestMatch(String search) throws BestResultNotFoundException {
        if  (search == null || search.isEmpty()){
            throw new BestResultNotFoundException(" Пусой поисковой запрос! ");
        }
        if (size == 0) {
            throw new BestResultNotFoundException(" Нет данных для поиска " + search);
        }

        String searchLower = search.toLowerCase();
        Searchable best = null;
        int bestCount = 0;
        for (int i = 0; i < size; i++) {
            String term = items[i].getSearchTerm().toLowerCase();
            int count = countOccurrences(term, searchLower);
            if (count > bestCount) {
                bestCount = count;
                best = items[i];
            }
        }
        if (best == null || bestCount == 0) {
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
