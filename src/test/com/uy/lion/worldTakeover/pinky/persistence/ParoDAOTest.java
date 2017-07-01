package com.uy.lion.worldTakeover.pinky.persistence;

import com.uy.lion.worldTakeover.pinky.entities.Paro;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.testng.Assert.assertNotNull;

/**
 * @author lion
 * @since 01/07/17
 */
public class ParoDAOTest {

    @Test
    public void testFetchAll() {
        List<Paro> obtenidos;
        obtenidos = ParoDAO.INSTANCE.fetchAll();
        assertNotNull(obtenidos);
    }

    @Test
    public void testFetchParo() {
        Paro oParo;
        oParo = ParoDAO.INSTANCE.fetchParo(LocalDateTime.now());
        assertNotNull(oParo);
    }


}