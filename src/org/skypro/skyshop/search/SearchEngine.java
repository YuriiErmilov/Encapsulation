package org.skypro.skyshop.search;
import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> items = new HashSet<>();

        public void add(Searchable item) {
            if (item != null) {
                items.add(item);
            }
        }

        public Set<Searchable> search(String query) {
            Comparator<Searchable> lengthComparator = (o1,o2) -> {
                int lengthCompare = Integer.compare(o2.getName().length(), o1.getName().length());
                    if (lengthCompare != 0) {
                        return lengthCompare;
                    }
                    return o1.getName().compareTo(o2.getName());
            };
            if (query == null || query.isBlank()) {
                return new TreeSet<>(lengthComparator);
            }
            String lowerQuery = query.toLowerCase();
            return items.stream().filter(item -> item.getSearchTerm().toLowerCase().contains(lowerQuery)).collect(Collectors.toCollection(() -> new TreeSet<>(lengthComparator)));
        }


        public Searchable findBestMatch(String search) throws BestResultNotFoundException {
            if (search == null || search.isBlank()) {
                throw new BestResultNotFoundException("Пустой поисковой запрос!");
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

        private int countOccurrences(String text, String search) {
            int count = 0;
            int index = 0;
            while ((index = text.indexOf(search, index)) != -1) {
                count++;
                index += search.length();
            }
            return count;
        }
    }
