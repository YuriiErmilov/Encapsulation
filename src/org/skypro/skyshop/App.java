package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import org.skypro.skyshop.exception.BestResultNotFoundException;

import java.util.*;

public class App {
    public static void main(String[] args) {



        ProductBasket basket = new ProductBasket("Anton");

        Product hookah = new DiscountProduct("Кальян: Alpha Hookah", 12000,15);
        Product theFlask = new SimpleProduct("Колба", 1500);
        Product forceps = new FixPriceProduct("Щипцы");


        basket.addProduct(hookah);
        basket.addProduct(theFlask);
        basket.addProduct(forceps);
        basket.addProduct(theFlask);

        basket.printInfoBasket();

        System.out.println("Удаляем существующий продукт");
        List<Product> removed = basket.removeProductsByName("Колба");

        if (removed.isEmpty()) {
            System.out.println("Список пуст");
        } else {
            for (Product p : removed) {
                System.out.println("Удален: " + p);
            }
        }
        basket.printInfoBasket();

        System.out.println("Удаляем несуществующий товар");
        List<Product> removed2 = basket.removeProductsByName("Дудка");
        if (removed2.isEmpty()) {
            System.out.println("Список пуст");
        }

        SearchEngine engine = new SearchEngine();

        engine.add(hookah);
        engine.add(theFlask);
        engine.add(forceps);

        Article a1 = new Article("Топ кальянов", "Список лучших кольянов....");
        Article a2 = new Article("Какие колбы подойдут", "Колбы подойдут к....");
        Article a3 = new Article("Акции месяца", "Самые выгодные товары....");

        engine.add(a1);
        engine.add(a2);
        engine.add(a3);
        System.out.println("Поиск кальян");
        Set<Searchable> results = engine.search("кальян");
        results.forEach(r -> System.out.println(r.getStringRepresentation()));

        System.out.println(" Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println(" Ищем товар который есть в корзине: " + basket.hasProduct("Кальян: Alpha Hookah"));

        System.out.println(" Ищем товар которого нет в корзине: " + basket.hasProduct("Mashave"));


        System.out.println(" Проверяем findBestMatch");

        try {
            Searchable best = engine.findBestMatch("Кальян");
            System.out.println(" ЛУчший результат по поиску 'Кальян' : " + best.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println(" Error " + e.getMessage());
        }

        try {
            Searchable best1 = engine.findBestMatch(" Ленолиум ");
            System.out.println(" ЛУчший результат по поиску 'Кальян' : " + best1.getStringRepresentation());
        } catch (BestResultNotFoundException e) {
            System.out.println(" Error " + e.getMessage());
        }


        basket.printInfoBasket();

        basket.cleatBasket();


        System.out.println(" Общая стоимость корзины: " + basket.getTotalPrice());

        System.out.println(" Ищем товар который есть в корзине: " + basket.hasProduct("Кальян: Alpha Hookah"));


    }
}