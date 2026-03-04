/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.MV_Paiement;
import com.impot.comptabilite.repos.MV_PaiementRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class MV_PaiementServicesImpl implements MV_PaiementServices {
    @Autowired
    MV_PaiementRepository mv_paiementRepository;
    
    
    @Override
    public MV_Paiement saveMV_Paiement(MV_Paiement e) {
        return mv_paiementRepository.save(e);
    }

    @Override
    public MV_Paiement updateMV_Paiement(MV_Paiement e) {
        return mv_paiementRepository.save(e);
    }

    @Override
    public void deleteMV_Paiement(MV_Paiement e) {
        mv_paiementRepository.delete(e);
    }

    @Override
    public void deleteMV_PaiementById(String id) {
        mv_paiementRepository.deleteById(id);
    }

    @Override
    public MV_Paiement getMV_Paiement(String id) {
    
        return mv_paiementRepository.findById(id).get();
    }
    

    @Override
    public List<MV_Paiement> getAllMV_Paiement() {
        return mv_paiementRepository.findAll();
    
    }
    
    @Override
    public List<MV_Paiement> recuperMV_Paiements() {
        return mv_paiementRepository.recuperMV_Paiements();
    
    }
}
