package com.uy.lion.worldTakeover.pinky.entities;

import java.time.LocalDateTime;

/**
 * @author lion
 * @since 18/06/17
 */
public class Paro {
    private int idParo;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    // TODO [LION] Create enum or persisted entity.
    private String strikeType;

    public Paro(int idParo, LocalDateTime beginDate, LocalDateTime endDate, String strikeType) {
        this.idParo = idParo;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.strikeType = strikeType;
    }

    // <editor-fold defaultstate="collapsed" desc="GETTERS & SETTERS">
    public int getIdParo() {
        return idParo;
    }

    public void setIdParo(int idParo) {
        this.idParo = idParo;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getStrikeType() {
        return strikeType;
    }

    public void setStrikeType(String strikeType) {
        this.strikeType = strikeType;
    }
    // </editor-fold>

}
