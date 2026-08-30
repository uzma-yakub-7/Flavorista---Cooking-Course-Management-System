package fridaytcbd.flavorista.entities;

import java.time.LocalDate;

public class Coupon {

    private Long id;
    private String code;
    private double discountPercentage;
    private LocalDate expiryDate;
    private boolean active;

    public Coupon() {
        this.active = true;
    }

    public Coupon(Long id, String code, double discountPercentage,
                  LocalDate expiryDate, boolean active) {
        this.id = id;
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.expiryDate = expiryDate;
        this.active = active;
    }

    public Coupon(String code, double discountPercentage,
                  LocalDate expiryDate) {
        this.code = code;
        this.discountPercentage = discountPercentage;
        this.expiryDate = expiryDate;
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
