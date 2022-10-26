package com.gremio.receiver.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MemberRequest {
    @NotBlank(message = "Name is Mandatory")
    private String memberName;
    @NotBlank(message = "Last Name is Mandatory")
    private String memberLastName;
    @NotNull(message = "Id is Mandatory")
    private Long id;
    @Email
    @NotBlank(message = "Email is Mandatory")
    private String email;
    @NotBlank(message = "Plate is Mandatory")
    private String cartPlate;
    @NotNull(message = "Member type is Mandatory")
    @Pattern(regexp = "premium|conventional", flags = Pattern.Flag.CASE_INSENSITIVE)
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
