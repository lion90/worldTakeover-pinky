package com.uy.lion.worldTakeover.pinky.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author lion.
 * @since 11/10/16.
 */
@Path("hayParo")
public class HayParo {


    private static final String CACHED_MESSAGE = "{\"paro\":\"false\"}";

    @GET
    @Produces("application/json")
    public String getHello() {
        return CACHED_MESSAGE;
    }

}
