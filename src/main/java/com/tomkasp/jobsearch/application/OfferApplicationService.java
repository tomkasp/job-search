package com.tomkasp.jobsearch.application;

import com.tomkasp.jobsearch.domain.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
@Service
public class OfferApplicationService {

    private final List<Offer> offers = new ArrayList<>();
    private final MapService mapService;

    @Autowired
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
