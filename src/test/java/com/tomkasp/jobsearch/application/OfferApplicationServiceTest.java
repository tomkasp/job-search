package com.tomkasp.jobsearch.application;

import com.tomkasp.jobsearch.domain.Offer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
@ExtendWith(MockitoExtension.class)
class OfferApplicationServiceTest {

    private static final String OFFER_TITLE = "job offer";
    private OfferApplicationService offerApplicationService;

    @Mock
    private MapsService mapsService;

    @BeforeEach
    void setUp() {
        offerApplicationService = new OfferApplicationService(mapsService);
    }

    @Test
    public void when_offer_is_created_then_its_stored() {
        //when
        offerApplicationService.createOffer(new Offer(OFFER_TITLE, ""));

        //then
        List<Offer> offers = offerApplicationService.retrieveAll();
        Assertions.assertThat(offers).containsExactly(new Offer(OFFER_TITLE, ""));
    }

    @Test
    public void when_offer_has_address_then_coordinates_are_added_if_missing() {
        //given:
        String address = "broadway street 22";
        String coordinates = "124";
        Mockito.when(mapsService.getCoordinatesFor(ArgumentMatchers.anyString())).thenReturn(coordinates);
        Offer offerUnderTest = new Offer("OFFER_TITLE", address);

        //when:
        offerApplicationService.createOffer(offerUnderTest);

        //then
        Assertions.assertThat(offerUnderTest.getCoordinates()).isEqualTo(coordinates);
    }

}