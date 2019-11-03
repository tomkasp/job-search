package com.tomkasp.jobsearch.application;

import com.google.maps.model.LatLng;
import com.tomkasp.jobsearch.domain.Offer;
import com.tomkasp.jobsearch.infrastracture.GoogleMapsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tomasz Kasprzycki
 */
@ExtendWith(MockitoExtension.class)
class OfferApplicationServiceTest {

    private static final String OFFER_TITLE = "job offer";
    private OfferApplicationService offerApplicationService;

    @Mock
    private GoogleMapsService googleMapsService;

    @BeforeEach
    void setUp() {
        offerApplicationService = new OfferApplicationService(googleMapsService);
    }

    @Test
    public void when_offer_is_created_then_its_stored() {
        //when
        offerApplicationService.createOffer(new Offer(OFFER_TITLE, ""));

        //then
        List<Offer> offers = offerApplicationService.retrieveAll();
        assertThat(offers).containsExactly(new Offer(OFFER_TITLE, ""));
    }

    @Test
    public void when_offer_has_address_then_coordinates_are_added() {
        //given:
        String address = "broadway street 22";
        LatLng coordinates = new LatLng(10,20);
        Mockito.when(googleMapsService.getCoordinatesFor(ArgumentMatchers.anyString())).thenReturn(coordinates);
        Offer offerUnderTest = new Offer("OFFER_TITLE", address);

        //when:
        offerApplicationService.createOffer(offerUnderTest);

        //then
        assertThat(offerUnderTest.getCoordinates().equals(coordinates)).isTrue();
    }

}