package com.gremio.receiver.model;

public class CartStock {
    private int cartId;
    private int remainingStock;


    public CartStock(int cartId, int remainingStock) {
        this.cartId = cartId;
        this.remainingStock = remainingStock;
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
