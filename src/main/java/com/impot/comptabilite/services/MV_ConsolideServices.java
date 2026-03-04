/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.MV_Consolide;

import java.util.List;


/**
 *
 * @author KISSIMA N'DIAYE
 */

public interface MV_ConsolideServices {

    MV_Consolide saveMV_Consolide(MV_Consolide e);
    MV_Consolide updateMV_Consolide(MV_Consolide e);
    void deleteMV_Consolide(MV_Consolide e);
    void deleteMV_ConsolideById(String id);
    MV_Consolide getMV_Consolide(String id);
    List<MV_Consolide> getAllMV_Consolide();
    
    List<MV_Consolide> recuperMV_Consolides();
    List<MV_Consolide> recuperImpotDirect();
    List<MV_Consolide> recuperImpotIndirect();
    List<MV_Consolide> recuperDroitEtTimbre();

    List<MV_Consolide> recuperMV_ConsolidesParStructure(String structure);
    List<MV_Consolide> recuperMV_ConsolidesParCodeImput(String codeImput);
    List<MV_Consolide> recuperMV_ConsolidesParStructureCode(String structure, String codeImput);
    List<MV_Consolide> recuperMV_ConsolidesParStructureMoisAnnee(String structure, int mois, int annee);

    List<MV_Consolide> recuperDonneesParStructureMoisAnnee(String structure, int mois, int annee);

    
}
