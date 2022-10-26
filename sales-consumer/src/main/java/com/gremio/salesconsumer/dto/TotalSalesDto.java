package com.gremio.salesconsumer.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "sales")
public class TotalSalesDto {

    @Id
    @NotNull
    @Column(name = "cart_id")
    private String cartId;

    @NotNull
    @Column(name = "count")
    private int count;

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
