package com.tomkasp.jobsearch.application;

import com.google.maps.model.LatLng;
import com.tomkasp.jobsearch.infrastracture.GoogleMapsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Tomasz Kasprzycki
 */
class GoogleMapsServiceTest {

    private static final String ADDRESS = "krakow";
    final LatLng ADDRESS_COORDINATES = new LatLng(50.06465010, 19.94497990);

    @Disabled
    @Test
    public void when_search_for_location_with_address_then_coordinates_are_returned() {
        GoogleMapsService googleMapsService = new GoogleMapsService();

        assertThat(googleMapsService.getCoordinatesFor(ADDRESS).equals(ADDRESS_COORDINATES));
    }
}