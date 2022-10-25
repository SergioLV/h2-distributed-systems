package com.gremio.receiver.dto;

import javax.validation.constraints.NotNull;

public class FugitiveCartRequest {
    @NotNull(message = "latitude is Mandatory")
    private Double latitude;

    @NotNull(message = "Longitude is Mandatory")
    private Double longitude;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
