package com.gremio.receiver.dao.entity;

import com.gremio.receiver.model.Sale;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "cart_id")
    private int cartId;
    @NotNull
    @Column(name = "client")
    private String client;
    @NotNull
    @Column(name = "amount")
    private int amount;
    @NotNull
    @Column(name = "sale_date")
    private String date;
    @NotNull
    @Column(name = "remainingStock")
    private int remainingStock;
    @NotNull
    @Column(name = "latitude")
    private Double latitude;
    @NotNull
    @Column(name = "longitude")
    private Double longitude;

    public SaleEntity(Sale sale) {
        this.cartId = sale.getCartId();
        this.client = sale.getClient();
        this.amount = sale.getAmount();
        this.date = sale.getDate();
        this.remainingStock = sale.getRemainingStock();
        this.latitude = sale.getLatitude();
        this.longitude = sale.getLongitude();
    }

    public SaleEntity() {

    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
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
}
