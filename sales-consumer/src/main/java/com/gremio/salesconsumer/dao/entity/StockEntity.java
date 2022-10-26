package com.gremio.salesconsumer.dao.entity;

import com.gremio.salesconsumer.model.Stock;

import javax.persistence.*;

@Entity
@Table(name = "stocks")
public class StockEntity {
    @Id
    @Column(name = "cart_id")
    private int cartId;

    @Column(name = "remaining_stock")
    private int remainingStock;

    public StockEntity(Stock stock){
        this.cartId = stock.getCartId();
        this.remainingStock = stock.getRemainingStock();
    }
    public StockEntity(){
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getRemainingStock() {
        return remainingStock;
    }

    public void setRemainingStock(int remainingStock) {
        this.remainingStock = remainingStock;
    }
}
