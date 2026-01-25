package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }
    @Override
    public String  getSearchTerm(){
        return title + " " + text;
    }
    @Override
    public String  getSearchableType(){
        return "ARTICLE";
    }
    @Override
    public String  getName(){
        return title;
    }

    @Override
    public String toString() {
        return "Название статьи" + title + '\'' +
                "Текст статьи" + text + '\'';
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
