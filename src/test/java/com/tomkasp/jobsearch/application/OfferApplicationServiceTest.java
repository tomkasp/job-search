package com.tomkasp.jobsearch.application;

import com.tomkasp.jobsearch.domain.Offer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
class OfferApplicationServiceTest {

    private static final String OFFER_TITLE = "job offer";

    @Test
    public void should_retrieve_all_added_offers(){
        OfferApplicationService offerApplicationService = new OfferApplicationService();
        offerApplicationService.createOffer(new Offer(OFFER_TITLE));

        List<Offer> offers = offerApplicationService.retrieveAll();

        Assertions.assertThat(offers).contains(new Offer(OFFER_TITLE));
    }

}