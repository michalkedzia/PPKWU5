package com.vcard.mk;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("@type")
    public String type;
    public String streetAddress;
    public String addressLocality;
    public String postalCode;
    public String addressCountry;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Address{" +
                "type='" + type + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", addressLocality='" + addressLocality + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", addressCountry='" + addressCountry + '\'' +
                '}';
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getAddressLocality() {
        return addressLocality;
    }

    public void setAddressLocality(String addressLocality) {
        this.addressLocality = addressLocality;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
}
