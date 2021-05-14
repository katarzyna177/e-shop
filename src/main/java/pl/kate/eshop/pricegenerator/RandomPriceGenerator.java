package pl.kate.eshop.pricegenerator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RandomPriceGenerator {

    public static BigDecimal generateRandomBigDecimalFromRange(double minPrice, double maxPrice) {
        BigDecimal randomBigDecimal = BigDecimal.valueOf(minPrice + (Math.random() * ((maxPrice - minPrice) + 1))).setScale(2, RoundingMode.HALF_UP);
        return randomBigDecimal;
    }

}
