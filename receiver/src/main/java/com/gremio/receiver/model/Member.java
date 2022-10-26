package com.gremio.receiver.model;

public class Member {

    private String memberName;
    private String memberLastName;
    private Long id;
    private String email;
    private String cartPlate;
    private String memberType;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLastName() {
        return memberLastName;
    }

    public void setMemberLastName(String memberLastName) {
        this.memberLastName = memberLastName;
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

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}

