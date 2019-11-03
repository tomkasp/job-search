package com.tomkasp.jobsearch.application;

import com.tomkasp.jobsearch.domain.Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
public class OfferApplicationService {

    private final List<Offer> offers = new ArrayList<>();
    private final MapService mapService;

    public OfferApplicationService(MapService mapService) {
        this.mapService = mapService;
    }

    public List<Offer> retrieveAll() {
        return offers;
    }

    public void createOffer(Offer offer) {
        offer.assignCoordinates(mapService);
        offers.add(offer);
    }
}
