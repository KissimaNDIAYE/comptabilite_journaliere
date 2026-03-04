/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.MV_Paiement;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */

public interface MV_PaiementServices {
    MV_Paiement saveMV_Paiement(MV_Paiement e);
    MV_Paiement updateMV_Paiement(MV_Paiement e);
    void deleteMV_Paiement(MV_Paiement e);
    void deleteMV_PaiementById(String id);
    MV_Paiement getMV_Paiement(String id);
    List<MV_Paiement> getAllMV_Paiement();
    
    List<MV_Paiement> recuperMV_Paiements();
}
