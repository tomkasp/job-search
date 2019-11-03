package com.tomkasp.jobsearch.application;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.FindPlaceFromText;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlacesSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.google.maps.FindPlaceFromTextRequest.FieldMask.FORMATTED_ADDRESS;
import static com.google.maps.FindPlaceFromTextRequest.FieldMask.GEOMETRY;
import static com.google.maps.FindPlaceFromTextRequest.InputType.TEXT_QUERY;

/**
 * @author Tomasz Kasprzycki
 */
public class MapsService {

    private final Logger LOG = LoggerFactory.getLogger(MapsService.class);

    GeoApiContext context;

    public MapsService() {
        context = new GeoApiContext.Builder()
                .apiKey("")
                .build();
    }


    public LatLng getCoordinatesFor(String address) {
        final FindPlaceFromText await;
        PlacesSearchResult[] candidates = new PlacesSearchResult[0];
        try {
            await = PlacesApi.findPlaceFromText(
                    context,
                    address,
                    TEXT_QUERY
            ).fields(GEOMETRY, FORMATTED_ADDRESS).await();
            candidates = await.candidates;
            LOG.info("query result: {}", candidates);
        } catch (ApiException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return candidates[0].geometry.location;
    }
}
