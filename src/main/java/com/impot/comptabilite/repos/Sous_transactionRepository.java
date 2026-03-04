/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.repos;

import com.impot.comptabilite.models.Sous_transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author KISSSIMA N'DIAYE
 */
public interface Sous_transactionRepository extends JpaRepository<Sous_transaction, Long>{
    
    //Recuperer toutes les SousTansaction dont TAX_TRANS_NO < 1000
    @Query("select p from Sous_transaction p where p.TAX_SUB_TRANS_NO < 2000") 
    List<Sous_transaction> findByTAX_SUB_TRANS_NO();
}
