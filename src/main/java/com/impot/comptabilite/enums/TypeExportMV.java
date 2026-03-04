package com.impot.comptabilite.enums;

public enum TypeExportMV {
    IMPOT_DIRECT("impots_directs"),
    IMPOT_INDIRECT("impots_indirects"),
    DROIT_TIMBRE("droits_timbres"),
    DONNEES("donnees"); 
    
    private final String fileName;
    
    TypeExportMV(String fileName) {
        this.fileName = fileName;
    }
    
    public String getFileName() {
        return fileName;
    }
}