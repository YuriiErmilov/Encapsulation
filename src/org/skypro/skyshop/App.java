package org.skypro.skyshop;
import org.skypro.skyshop.product.DiscountProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket("Anton");

        Product hookah = new DiscountProduct("Кальян: Alpha Hookah", 12000,15);
        Product theFlask = new SimpleProduct("Колба", 1500);
        Product forceps = new FixPriceProduct("Щипцы ");

        basket1.addProduct(hookah);
        basket1.addProduct(theFlask);
        basket1.addProduct(forceps);

        basket1.printInfoBasket();

        System.out.println(" Общая стоимость корзины: " + basket1.getTotalPrice());

        System.out.println(" Ищем товар который есть в корзине: " + basket1.hasProduct("Кальян: Alpha Hookah"));

        System.out.println(" Ищем товар которого нет в корзине: " + basket1.hasProduct("Mashave"));

        basket1.cleatBasket();

        basket1.printInfoBasket();

        System.out.println(" Общая стоимость корзины: " + basket1.getTotalPrice());

        System.out.println(" Ищем товар который есть в корзине: " + basket1.hasProduct("Кальян: Alpha Hookah"));


    }
}