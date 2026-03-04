/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Transaction;
import com.impot.comptabilite.repos.TransactionRepository;

import java.math.BigInteger;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class TransactionServicesImpl implements TransactionServices {
    @Autowired
    TransactionRepository transactionRepository;
    
    
    @Override
    public Transaction saveTransaction(Transaction e) {
        return transactionRepository.save(e);
    }

    @Override
    public Transaction updateTransaction(Transaction e) {
        return transactionRepository.save(e);
    }

    @Override
    public void deleteTransaction(Transaction e) {
        transactionRepository.delete(e);
    }

    @Override
    public void deleteTransactionById(BigInteger id) {
        transactionRepository.deleteById(id);
    }

    @Override
    public Transaction getTransaction(BigInteger id) {
    
        return transactionRepository.findById(id).get();
    }
    

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    
    }
    @Override
    public List<Transaction> findByTAX_TRANS_NO() {
        return transactionRepository.findByTAX_TRANS_NO();
    
    }
}
