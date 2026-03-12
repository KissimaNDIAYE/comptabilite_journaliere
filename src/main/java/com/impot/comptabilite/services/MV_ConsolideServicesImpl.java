/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.MV_Consolide;
import com.impot.comptabilite.repos.MV_ConsolideRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class MV_ConsolideServicesImpl implements MV_ConsolideServices {
    @Autowired
    MV_ConsolideRepository mv_consolideRepository;
    
    @Override
    public MV_Consolide saveMV_Consolide(MV_Consolide e) {
        return mv_consolideRepository.save(e);
    }

    @Override
    public MV_Consolide updateMV_Consolide(MV_Consolide e) {
        return mv_consolideRepository.save(e);
    }

    @Override
    public void deleteMV_Consolide(MV_Consolide e) {
        mv_consolideRepository.delete(e);
    }

    @Override
    public void deleteMV_ConsolideById(String id) {
        mv_consolideRepository.deleteById(id);
    }

    @Override
    public MV_Consolide getMV_Consolide(String id) {
    
        return mv_consolideRepository.findById(id).get();
    }
    

    @Override
    public List<MV_Consolide> getAllMV_Consolide() {
        return mv_consolideRepository.findAll();
    
    }
    
    @Override
    public List<MV_Consolide> recuperMV_Consolides() {
        return mv_consolideRepository.recuperMV_Consolides();
    
    }
    

    // @Override
    public List<Object[]> recuperImpotDirect(Integer annee, Integer mois, String structure) {
        return mv_consolideRepository.recuperImpotDirect(annee, mois, structure);
    }
    // @Override
    public List<Object[]> recuperImpotIndirect(Integer annee, Integer mois, String structure) {
        return mv_consolideRepository.recuperImpotIndirect(annee, mois, structure);
    }
    // @Override
    public List<Object[]> recuperDroitEtTimbre(Integer annee, Integer mois, String structure) {
        return mv_consolideRepository.recuperDroitEtTimbre(annee, mois, structure);
    }


    @Override
    public List<Integer> recuperMois() {
        return mv_consolideRepository.recuperMois();
    }  

    @Override
    public List<Integer> recuperAnnee() {
        return mv_consolideRepository.recuperAnnee();
    } 
    
    @Override
    public List<String> recuperStructures() {
        return mv_consolideRepository.recuperStructures();
    }  

    // @Override
    //     public List<Object[]> recuperImpotDirect() {
    //         return mv_consolideRepository.recuperImpotDirect();
    //     }

    // @Override
    // public List<MV_Consolide> recuperImpotIndirect() {
    //     return mv_consolideRepository.recuperImpotIndirect();
    // }
    
    @Override
    public List<MV_Consolide> recuperDroitEtTimbre() {
        return mv_consolideRepository.recuperDroitEtTimbre();
    }

    @Override
    public List<MV_Consolide> recuperMV_ConsolidesParStructure(String structure) {
        return mv_consolideRepository.recuperMV_ConsolidesParStructure(structure);
    } 

    @Override
    public List<MV_Consolide> recuperMV_ConsolidesParCodeImput(String codeImput) {
        return mv_consolideRepository.recuperMV_ConsolidesParCodeImput(codeImput);
    }

    @Override
    public List<MV_Consolide> recuperMV_ConsolidesParStructureCode(String structure, String codeImput) {
        return mv_consolideRepository.recuperMV_ConsolidesParStructureCode(structure, codeImput);
    }

    @Override
    public List<MV_Consolide> recuperMV_ConsolidesParStructureMoisAnnee(String structure, int mois, int annee) {
        return mv_consolideRepository.recuperMV_ConsolidesParStructureMoisAnnee(structure, mois, annee);
    }

    @Override
        public List<Object[]> recuperObjetMV_ConsolidesParStructureMoisAnnee(String structure, int mois, int annee) {
            return mv_consolideRepository.recuperObjetMV_ConsolidesParStructureMoisAnnee(structure, mois, annee);
        }

    @Override
    public List<MV_Consolide> recuperDonneesParStructureMoisAnnee(String structure, int mois, int annee) {
        return mv_consolideRepository.recuperDonneesParStructureMoisAnnee(structure, mois, annee);
    }

}
