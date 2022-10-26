package com.gremio.receiver.dto;

import javax.validation.constraints.NotNull;

public class FugitiveCartRequest {

    @NotNull
    private int cartId;
    @NotNull(message = "latitude is Mandatory")
    private Double latitude;

    @NotNull(message = "Longitude is Mandatory")
    private Double longitude;

    private String isFugitive;

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
