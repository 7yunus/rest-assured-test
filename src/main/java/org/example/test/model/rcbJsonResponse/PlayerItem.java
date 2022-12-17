package org.example.test.model.rcbJsonResponse;

import com.google.gson.annotations.SerializedName;

public class PlayerItem {

    @SerializedName("country")
    private String country;

    @SerializedName("role")
    private String role;

    @SerializedName("name")
    private String name;

    @SerializedName("price-in-crores")
    private String priceInCrores;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriceInCrores() {
        return priceInCrores;
    }

    public void setPriceInCrores(String priceInCrores) {
        this.priceInCrores = priceInCrores;
    }

    @Override
    public String toString() {
        return
                "PlayerItem{" +
                        "country = '" + country + '\'' +
                        ",role = '" + role + '\'' +
                        ",name = '" + name + '\'' +
                        ",price-in-crores = '" + priceInCrores + '\'' +
                        "}";
    }
}