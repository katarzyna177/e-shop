package pl.kate.eshop.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("PLUS")
@Data
public class ShopPLUS extends ShopSTART {

    @Value("${product-info.vat}")
    private BigDecimal vat;

    public BigDecimal finalSumWithVat() {
        BigDecimal sum = sumOfProducts();
        return sum.add(sum.multiply(getVat())).setScale(2, RoundingMode.HALF_UP);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getShopPLUS(){
        System.out.println("ShopPLUS");
        System.out.println("Suma produktów z VAT: " + finalSumWithVat());
    }

}
