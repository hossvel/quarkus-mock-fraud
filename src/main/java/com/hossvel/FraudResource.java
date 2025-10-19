package com.hossvel;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/fraud")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FraudResource {

    @Inject
    FraudService fraudService;

    @POST
    @Path("/check")
    public boolean check(TransferRequest request) {

       return fraudService.check(request);
    }
}
