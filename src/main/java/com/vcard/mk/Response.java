package com.vcard.mk;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Response {
    @JsonProperty("@context")
    public String context;
    @JsonProperty("@type")
    public String type;
    public String name;
    public String image;
    public String telephone;
    public String email;
    public String sameAs;
    public String url;
    public Address address;
    public List<OpeningHoursSpecification> openingHoursSpecification;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSameAs() {
        return sameAs;
    }

    public void setSameAs(String sameAs) {
        this.sameAs = sameAs;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Response{" +
                "context='" + context + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", sameAs='" + sameAs + '\'' +
                ", url='" + url + '\'' +
                ", address=" + address +
                ", openingHoursSpecification=" + openingHoursSpecification +
                '}';
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<OpeningHoursSpecification> getOpeningHoursSpecification() {
        return openingHoursSpecification;
    }

    public void setOpeningHoursSpecification(List<OpeningHoursSpecification> openingHoursSpecification) {
        this.openingHoursSpecification = openingHoursSpecification;
    }
}
