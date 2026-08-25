package fridaytcbd.flavorista.strategy;

public class StudentDiscount extends DiscountStrategy {

    private static final double DISCOUNT = 0.10;

    @Override
    public double getDiscountPercentage() {
        return DISCOUNT;
    }
}
