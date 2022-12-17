package org.example.test.model.rcbJsonResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RcbJsonResponse {

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    @SerializedName("player")
    private List<PlayerItem> player;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<PlayerItem> getPlayer() {
        return player;
    }

    public void setPlayer(List<PlayerItem> player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return
                "RcbJsonResponse{" +
                        "name = '" + name + '\'' +
                        ",location = '" + location + '\'' +
                        ",player = '" + player + '\'' +
                        "}";
    }
}