package com.tomkasp.jobsearch.application;

import com.google.maps.model.LatLng;

/**
 * @author Tomasz Kasprzycki
 */
public interface MapService {
    LatLng getCoordinatesFor(String address);
}
