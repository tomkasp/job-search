package com.tomkasp.jobsearch.application;

import com.tomkasp.jobsearch.domain.Offer;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
public class OfferApplicationService {

    private List<Offer> offers = new ArrayList<>();

    public List<Offer> retrieveAll() {
        return offers;
    }

    public void createOffer(Offer offer) {
        offers.add(offer);
    }
}
