/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.repos;

import com.impot.comptabilite.models.MV_Consolide;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Admin
 */
public interface MV_ConsolideRepository extends JpaRepository<MV_Consolide, String>{
    
    //Recuperer touts les impôts direct
    @Query("SELECT c FROM MV_Consolide c WHERE c.codeImput IN ('71.1.1.10','71.1.1.12','71.1.2.10','71.1.2.11','71.1.2.12','71.1.2.20','71.1.4.10','71.1.4.11','71.1.4.12','71.1.4.13','71.1.7.10','71.2.1.30','71.4.4.11','71.4.4.12','71.4.5.10','71.4.6.10','71.4.9.10','71.4.9.11') ORDER BY c.codeImput")
    List<MV_Consolide> recuperImpotDirect();


    //Recuperer touts les impôts indirect
    @Query("SELECT c FROM MV_Consolide c WHERE c.codeImput IN ('71.5.1.10','71.5.1.20','71.5.2.11','71.5.2.30','71.5.2.31','71.5.2.91','71.5.3.11','71.5.3.12','71.5.3.30','71.5.4.10','71.5.4.11','71.5.9.10','71.5.9.12') ORDER BY c.codeImput")
    List<MV_Consolide> recuperImpotIndirect();
    
    //Recuperer toutes les droits et timbres
    @Query("SELECT c FROM MV_Consolide c WHERE c.codeImput IN ('71.6.1.10','71.6.1.11','71.6.3.10','71.6.4.10','71.6.4.11','71.6.9.10') ORDER BY c.codeImput")
    List<MV_Consolide> recuperDroitEtTimbre();
    
    //Recuperer toutes les donnees par structure, mois, annee
    @Query("SELECT c FROM MV_Consolide c WHERE c.structure = :structure AND c.mois = :mois AND c.annee = :annee AND c.codeImput IN ('71.6.1.10','71.6.1.11','71.6.3.10','71.6.4.10','71.6.4.11','71.6.9.10', '71.5.1.10','71.5.1.20','71.5.2.11','71.5.2.30','71.5.2.31','71.5.2.91','71.5.3.11','71.5.3.12','71.5.3.30','71.5.4.10','71.5.4.11','71.5.9.10','71.5.9.12') ORDER BY c.codeImput")
    List<MV_Consolide> recuperDonneesParStructureMoisAnnee(@Param("structure") String structure, @Param("mois") int mois, @Param("annee") int annee);
        
    //Recuperer les MV_Consolide par structure
    @Query("SELECT c FROM MV_Consolide c WHERE c.structure = :structure")
    List<MV_Consolide> recuperMV_ConsolidesParStructure(@Param("structure") String structure);

    //Recuperer les MV_Consolide par CODE_IMPUT
    @Query("SELECT c FROM MV_Consolide c WHERE c.codeImput = :codeImput")
    List<MV_Consolide> recuperMV_ConsolidesParCodeImput(@Param("codeImput") String codeImput);

    //Recuperer les MV_Consolide par CODE_IMPUT et structure
    @Query("SELECT c FROM MV_Consolide c WHERE c.structure = :structure AND c.codeImput = :codeImput")
    List<MV_Consolide> recuperMV_ConsolidesParStructureCode(@Param("structure") String structure, @Param("codeImput") String codeImput);

    //Recuperer les MV_Consolide par structure, mois, annee
     @Query("SELECT c FROM MV_Consolide c WHERE c.structure = :structure AND c.mois = :mois AND c.annee = :annee")
    List<MV_Consolide> recuperMV_ConsolidesParStructureMoisAnnee(@Param("structure") String structure, @Param("mois") int mois, @Param("annee") int annee);
    
    //Recuperer toutes les MV_Consolide 
    @Query("SELECT c FROM MV_Consolide c")
    List<MV_Consolide> recuperMV_Consolides();

    // @Query("SELECT c FROM MV_Consolide c")
    // List<MV_Consolide> findTop100();

    // @Query(value = "SELECT * FROM MV_Consolide WHERE ROWNUM <= 100", nativeQuery = true)
    // List<MV_Consolide> recuperMV_Consolides();


    

}
