package pl.kate.eshop.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kate.eshop.domain.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static pl.kate.eshop.pricegenerator.RandomPriceGenerator.generateRandomBigDecimalFromRange;

@Component
@Profile("START")
public class ShopSTART {
    private List<Product> productList;

    public BigDecimal sumOfProducts(){
        return productList.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    double minPrice = 50.00;
    double maxPrice = 300.00;

    public ShopSTART(){
        Product product1 = new Product("Domek", generateRandomBigDecimalFromRange(minPrice, maxPrice));
        Product product2 = new Product("Piłka",  generateRandomBigDecimalFromRange(minPrice, maxPrice));
        Product product3 = new Product("Namiot", generateRandomBigDecimalFromRange(minPrice, maxPrice));
        Product product4 = new Product("Suszarka", generateRandomBigDecimalFromRange(minPrice, maxPrice));
        Product product5 = new Product("Krzesło", generateRandomBigDecimalFromRange(minPrice, maxPrice));
        productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getShopSTART(){
        System.out.println("ShopSTART");
        System.out.println(productList);
        System.out.println("Suma produktów: " + sumOfProducts());



    }



}
