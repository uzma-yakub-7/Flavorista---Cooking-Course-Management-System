package fridaytcbd.flavorista.strategy;

public class SeasonalDiscount extends DiscountStrategy {

    private static final double DISCOUNT = 0.15;

    @Override
    public double getDiscountPercentage() {
        return DISCOUNT;
    }
}
