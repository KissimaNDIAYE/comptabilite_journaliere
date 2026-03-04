/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Sous_transaction;
import com.impot.comptabilite.repos.Sous_transactionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class Sous_transactionServicesImpl implements Sous_transactionServices {
    @Autowired
    Sous_transactionRepository transactionRepository;
    
    
    @Override
    public Sous_transaction saveSous_transaction(Sous_transaction e) {
        return transactionRepository.save(e);
    }

    @Override
    public Sous_transaction updateSous_transaction(Sous_transaction e) {
        return transactionRepository.save(e);
    }

    @Override
    public void deleteSous_transaction(Sous_transaction e) {
        transactionRepository.delete(e);
    }

    @Override
    public void deleteSous_transactionById(Long id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Sous_transaction getSous_transaction(Long id) {
    
        return transactionRepository.findById(id).get();
    }
    

    @Override
    public List<Sous_transaction> getAllSous_transaction() {
        return transactionRepository.findAll();
    
    }
    @Override
    public List<Sous_transaction> findByTAX_SUB_TRANS_NO() {
        return transactionRepository.findByTAX_SUB_TRANS_NO();
    
    }
}
