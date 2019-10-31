package com.tomkasp.jobsearch.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.tomkasp.jobsearch.application.MapsService;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isNoneEmpty;

/**
 * @author Tomasz Kasprzycki
 */
@JsonDeserialize
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Offer implements Serializable {

    private final String offerTitle;
    private final String address;
    private String coordinates;

    public Offer(String offerTitle, String address) {
        this.offerTitle = offerTitle;
        this.address = address;
    }

    public void assignCoordinates(MapsService mapsService) {
        if (isNoneEmpty(this.address)) {
            this.coordinates = mapsService.getCoordinatesFor(this.address);
        }
    }

    public String getCoordinates() {
        return this.coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(offerTitle, offer.offerTitle) &&
                Objects.equals(address, offer.address) &&
                Objects.equals(coordinates, offer.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerTitle, address, coordinates);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerTitle='" + offerTitle + '\'' +
                ", address='" + address + '\'' +
                ", coordinates='" + coordinates + '\'' +
                '}';
    }
}
