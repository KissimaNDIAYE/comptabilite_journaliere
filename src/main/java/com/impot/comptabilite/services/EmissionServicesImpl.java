/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Emission;
import com.impot.comptabilite.repos.EmissionRepository;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class EmissionServicesImpl implements EmissionServices {
    @Autowired
    EmissionRepository emissionRepository;
    
    
    @Override
    public Emission saveEmission(Emission e) {
        return emissionRepository.save(e);
    }

    @Override
    public Emission updateEmission(Emission e) {
        return emissionRepository.save(e);
    } 

    @Override
    public void deleteEmission(Emission e) {
        emissionRepository.delete(e);
    }

    @Override
    public void deleteEmissionById(BigInteger id) {
        emissionRepository.deleteById(id);
    }

    @Override
    public Emission getEmission(BigInteger id) {
    
        return emissionRepository.findById(id).get();
    }
    

    @Override
    public List<Emission> getAllEmission() {
        return emissionRepository.findAll();
    
    }
    
    @Override
    public List<Emission> findByASSESS_NO() {
        return emissionRepository.findByASSESS_NO();
    
    }
}
