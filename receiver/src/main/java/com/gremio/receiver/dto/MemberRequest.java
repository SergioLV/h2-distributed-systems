package com.gremio.receiver.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MemberRequest {
    @NotBlank(message = "Name is Mandatory")
    private String name;
    @NotBlank(message = "Last Name is Mandatory")
    private String lastName;
    @NotNull(message = "Id is Mandatory")
    private Long id;
    @Email
    @NotBlank(message = "Email is Mandatory")
    private String email;
    @NotBlank(message = "Plate is Mandatory")
    private String cartPlate;
    @NotNull(message = "isPremium is Mandatory")
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
