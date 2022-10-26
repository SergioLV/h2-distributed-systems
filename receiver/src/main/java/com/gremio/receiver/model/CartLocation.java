package com.gremio.receiver.model;

public class CartLocation {

    private int cartId;
    private Double latitude;

    private Double longitude;

    private String isFugitive;

    public CartLocation(int cartId, Double latitude, Double longitude, String isFugitive) {
        this.cartId = cartId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isFugitive = isFugitive;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getIsFugitive() {
        return isFugitive;
    }

    public void setIsFugitive(String isFugitive) {
        this.isFugitive = isFugitive;
    }
}
