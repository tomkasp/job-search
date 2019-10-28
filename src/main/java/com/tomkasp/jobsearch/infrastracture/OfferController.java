package com.tomkasp.jobsearch.infrastracture;

import com.tomkasp.jobsearch.application.OfferApplicationService;
import com.tomkasp.jobsearch.domain.Offer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
@RestController
@RequestMapping(value = "/offers")
public class OfferController {

    OfferApplicationService offerApplicationService = new OfferApplicationService();

    @GetMapping
    public List<Offer> getOffers(){
        return offerApplicationService.retrieveAll();
    }

    @PutMapping
    public void createOffer(@RequestBody Offer offer){
        offerApplicationService.createOffer(offer);
    }
}
