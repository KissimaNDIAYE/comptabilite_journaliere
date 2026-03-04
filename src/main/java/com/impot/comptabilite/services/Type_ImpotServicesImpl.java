/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Type_Impot;
import com.impot.comptabilite.repos.Type_ImpotRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class Type_ImpotServicesImpl implements Type_ImpotServices {
    @Autowired
    Type_ImpotRepository type_impotRepository;
    
    
    @Override
    public Type_Impot saveType_Impot(Type_Impot e) {
        return type_impotRepository.save(e);
    }

    @Override
    public Type_Impot updateType_Impot(Type_Impot e) {
        return type_impotRepository.save(e);
    }

    @Override
    public void deleteType_Impot(Type_Impot e) {
        type_impotRepository.delete(e);
    }

    @Override
    public void deleteType_ImpotById(Long id) {
        type_impotRepository.deleteById(id);
    }

    @Override
    public Type_Impot getType_Impot(Long id) {
    
        return type_impotRepository.findById(id).get();
    }
    

    @Override
    public List<Type_Impot> getAllType_Impot() {
        return type_impotRepository.findAll();
    
    }
}
