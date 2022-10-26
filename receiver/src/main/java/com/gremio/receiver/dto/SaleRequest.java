package com.gremio.receiver.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class SaleRequest {
    @NotBlank(message = "Cart  id is mandatory")
    private String cartId;
    @NotBlank(message = "Client is Mandatory")
    private String clientName;
    @NotNull(message = "Amount is Mandatory")
    private int amount;
    @NotBlank(message = "Date is Mandatory")
    private String date;
    @NotNull(message = "Remaining Stock is Mandatory")
    private int remainingStock;

    @NotNull(message = "Latitude is mandatory")
    private Double latitude;

    @NotNull(message = "Longitude is mandatory")
    private Double longitude;

    @NotNull(message = "Sale Type is mandatory")
    @Pattern(regexp = "credit|debit", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String saleType;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
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

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }
}
