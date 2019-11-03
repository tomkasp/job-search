package com.tomkasp.jobsearch.infrastracture;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResult;
import com.tomkasp.jobsearch.application.MapCoordinatesFetchOperationFailed;
import com.tomkasp.jobsearch.application.MapService;
import io.vavr.collection.Array;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.google.maps.FindPlaceFromTextRequest.FieldMask.FORMATTED_ADDRESS;
import static com.google.maps.FindPlaceFromTextRequest.FieldMask.GEOMETRY;
import static com.google.maps.FindPlaceFromTextRequest.InputType.TEXT_QUERY;

/**
 * @author Tomasz Kasprzycki
 */
@Service
public class GoogleMapsService implements MapService {

    private final Logger LOG = LoggerFactory.getLogger(GoogleMapsService.class);

    private final GeoApiContext context;

    public GoogleMapsService() {
        String api = "";
        context = new GeoApiContext.Builder()
                .apiKey(api)
                .build();
    }

    @Override
    public LatLng getCoordinatesFor(String address) {
        try {
            return runGoogleApiQueryFor(address);
        } catch (Exception e) {
            LOG.error("Coordinates fetch fail :", e);
            throw new MapCoordinatesFetchOperationFailed();
        }
    }

    private LatLng runGoogleApiQueryFor(String address) throws ApiException, InterruptedException, IOException {
        final PlacesSearchResult[] candidates = PlacesApi.findPlaceFromText(
                context,
                address,
                TEXT_QUERY
        ).fields(GEOMETRY, FORMATTED_ADDRESS).await().candidates;
        return Array.of(candidates).head().geometry.location;
    }
}
