package fridaytcbd.flavorista.entities;

public class Address {

    private Long id;
    private Long userId;
    private String label;
    private String addressLine;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private double latitude;
    private double longitude;
    private boolean defaultAddress;

    public Address() {
    }

    public Address(Long id, Long userId, String label,
                   String addressLine, String city, String state,
                   String postalCode, String country,
                   double latitude, double longitude,
                   boolean defaultAddress) {

        this.id = id;
        this.userId = userId;
        this.label = label;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.defaultAddress = defaultAddress;
    }

    public Address(Long userId, String label,
                   String addressLine, String city,
                   String state, String postalCode,
                   String country) {

        this.userId = userId;
        this.label = label;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
