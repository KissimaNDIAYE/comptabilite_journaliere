/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Transaction;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */
public interface TransactionServices {
    Transaction saveTransaction(Transaction e);
    Transaction updateTransaction(Transaction e);
    void deleteTransaction(Transaction e);
    void deleteTransactionById(BigInteger id);
    Transaction getTransaction(BigInteger id);
    List<Transaction> getAllTransaction();
    
    List<Transaction> findByTAX_TRANS_NO();
}
