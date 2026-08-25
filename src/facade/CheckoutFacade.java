package fridaytcbd.flavorista.facade;

import fridaytcbd.flavorista.entities.Cart;
import fridaytcbd.flavorista.strategy.DiscountStrategy;

public class CheckoutFacade {

    private final DiscountStrategy discountStrategy;

    public CheckoutFacade(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateSubtotal(Cart cart) {
        if (cart == null) {
            return 0.0;
        }

        return cart.getSubtotal();
    }

    public double calculateDiscount(Cart cart) {
        if (cart == null || discountStrategy == null) {
            return 0.0;
        }

        double subtotal = cart.getSubtotal();

        return discountStrategy.calculateDiscount(subtotal);
    }

    public double calculateFinalTotal(Cart cart) {
        if (cart == null) {
            return 0.0;
        }

        double subtotal = cart.getSubtotal();

        if (discountStrategy == null) {
            return subtotal;
        }

        return discountStrategy.calculateFinalPrice(subtotal);
    }
}
