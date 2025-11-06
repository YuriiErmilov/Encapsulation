package org.skypro.skyshop;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
public class App {
    public static void main(String[] args) {
        ProductBasket basket1 = new ProductBasket("Anton");

        Product hookah = new Product("Кальян: Alpha Hookah", 12000);
        Product theFlask = new Product("Колба", 1500);
        Product forceps = new Product("Щипцы", 1200);
        Product bathed = new Product("Купал", 500);
        Product calaud = new Product("Калауд", 300);
        Product tabacco = new Product("Табак : Dark ", 390);

        basket1.addProduct(hookah);
        basket1.addProduct(theFlask);
        basket1.addProduct(forceps);
        basket1.addProduct(bathed);
        basket1.addProduct(calaud);

        basket1.addProduct(tabacco);

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