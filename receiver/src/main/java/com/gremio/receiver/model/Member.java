package com.gremio.receiver.model;

public class Member {

    private String name;
    private String lastName;
    private Long id;
    private String email;
    private String cartPlate;
    private boolean isPremium;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCartPlate() {
        return cartPlate;
    }

    public void setCartPlate(String cartPlate) {
        this.cartPlate = cartPlate;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }
}

