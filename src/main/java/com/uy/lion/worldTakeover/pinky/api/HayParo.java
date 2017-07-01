package com.uy.lion.worldTakeover.pinky.api;

import com.google.gson.Gson;
import com.uy.lion.worldTakeover.pinky.entities.Paro;
import com.uy.lion.worldTakeover.pinky.persistence.ParoDAO;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.LocalDateTime;

/**
 * @author lion.
 * @since 11/10/16.
 */
@Singleton
@Path("hayParo")
public class HayParo {

    /**
     * Default constructor.
     */
    public HayParo() {
        // NOTHING TO DO.
    }

    @GET
    @Produces("application/json")
    public String get() {
        Gson oGson = new Gson();
        return oGson.toJson(fetchHayParo());
//        return "{\"paro\":\"" + String.valueOf(fetchHayParo()) + "\"}";
    }

    private Paro fetchHayParo() {
        return ParoDAO.INSTANCE.fetchParo(LocalDateTime.now());
    }


//    private String toJSON(Object[][] aValues) {
//        StringBuilder sBuilder = new StringBuilder();
//        sBuilder.append("{");
//        for (Object[] aClaves : aValues) {
//
//        }
//        return "";
//    }
}
