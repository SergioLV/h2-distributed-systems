package com.gremio.salesconsumer.dto;

import com.gremio.salesconsumer.model.Sale;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
public class SalesDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(name = "cart_id")
    private int cartId;
    @NotNull
    @Column(name = "client_name")
    private String clientName;
    @NotNull
    @Column(name = "amount")
    private int amount;
    @NotNull
    @Column(name = "sale_date")
    private String date;
    @NotNull
    @Column(name = "remaining_stock")
    private int remainingStock;
    @NotNull
    @Column(name = "latitude")
    private Double latitude;
    @NotNull
    @Column(name = "longitude")
    private Double longitude;
    @NotNull
    @Column(name = "sale_type")
    private String saleType;

    public SalesDto(Sale sale) {
        this.cartId = sale.getCartId();
        this.clientName = sale.getClientName();
        this.amount = sale.getAmount();
        this.date = sale.getDate();
        this.remainingStock = sale.getRemainingStock();
        this.latitude = sale.getLatitude();
        this.longitude = sale.getLongitude();
        this.saleType = sale.getSaleType();
    }

    public SalesDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
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
