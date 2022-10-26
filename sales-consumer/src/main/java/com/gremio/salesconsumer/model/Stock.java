package com.gremio.salesconsumer.model;

public class Stock {
    private int cartId;
    private int remainingStock;

    public int getCartId() {
        return cartId;
    }

    public Stock(int cartId, int remainingStock) {
        this.cartId = cartId;
        this.remainingStock = remainingStock;
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
