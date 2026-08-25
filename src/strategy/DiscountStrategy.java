package fridaytcbd.flavorista.strategy;

public abstract class DiscountStrategy {

    public abstract double getDiscountPercentage();

    public double calculateDiscount(double subtotal) {
        if (subtotal <= 0) {
            return 0.0;
        }

        return subtotal * getDiscountPercentage();
    }

    public double calculateFinalPrice(double subtotal) {
        if (subtotal <= 0) {
            return 0.0;
        }

        return subtotal - calculateDiscount(subtotal);
    }
}
