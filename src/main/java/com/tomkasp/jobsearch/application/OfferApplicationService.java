package com.tomkasp.jobsearch.application;

import com.tomkasp.jobsearch.domain.Offer;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.isNoneEmpty;

/**
 * @author Tomasz Kasprzycki
 */
public class OfferApplicationService {

    private List<Offer> offers = new ArrayList<>();
    private final MapsService mapsService;

    public OfferApplicationService(MapsService mapsService) {
        this.mapsService = mapsService;
    }

    public List<Offer> retrieveAll() {
        return offers;
    }

    public void createOffer(Offer offer) {
        offer.assignCoordinates(mapsService);
        offers.add(offer);
    }
}
