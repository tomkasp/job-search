package com.tomkasp.jobsearch.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Tomasz Kasprzycki
 */
@JsonDeserialize
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Offer implements Serializable {

    private String offerTitle;

    protected Offer() {
    }

    public Offer(String offerTitle) {
        this.offerTitle = offerTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Offer)) return false;
        Offer offer = (Offer) o;
        return Objects.equals(offerTitle, offer.offerTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerTitle);
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerTitle='" + offerTitle + '\'' +
                '}';
    }
}
