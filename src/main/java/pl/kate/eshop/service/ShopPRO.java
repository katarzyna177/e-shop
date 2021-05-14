package pl.kate.eshop.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.kate.eshop.service.ShopPLUS;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
@Profile("PRO")
@Data
public class ShopPRO extends ShopPLUS {

    @Value("${product-info.discount}")
    private BigDecimal discount;

    public BigDecimal finalSumAfterDiscount(){
        BigDecimal sumWithVat = finalSumWithVat();
        return sumWithVat.subtract(sumWithVat.multiply(getDiscount()).setScale(2, RoundingMode.HALF_UP));
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getShopPRO(){
        System.out.println("ShopPRO");
        System.out.println(finalSumAfterDiscount());
    }
}
