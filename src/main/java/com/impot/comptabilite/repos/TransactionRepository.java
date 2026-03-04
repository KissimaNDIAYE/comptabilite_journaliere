/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.repos;

import com.impot.comptabilite.models.Transaction;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface TransactionRepository extends JpaRepository<Transaction, BigInteger>{
    
    //Recuperer toutes les Transaction dont TAX_TRANS_NO < 1000
    @Query("select p from Transaction p where p.TAX_TRANS_NO < 100") 
    List<Transaction> findByTAX_TRANS_NO();
    
}
