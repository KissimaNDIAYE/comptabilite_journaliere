/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.repos;

import com.impot.comptabilite.models.MV_Paiement;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface MV_PaiementRepository extends JpaRepository<MV_Paiement, String>{
    
    //Recuperer toutes les MV_Paiement dont ASSESS_NO < 1000
     @Query(value = "SELECT * FROM MV_PAIEMENT FETCH FIRST 10 ROWS ONLY", nativeQuery = true)
    List<MV_Paiement> recuperMV_Paiements();

    //Recuperer toutes les MV_Paiement dont ASSESS_NO < 1000
    // @Query("select p from MV_Paiement p where p.ASSESS_NO < 1000") 
    // List<MV_Paiement> findByASSESS_NO();
    
}
