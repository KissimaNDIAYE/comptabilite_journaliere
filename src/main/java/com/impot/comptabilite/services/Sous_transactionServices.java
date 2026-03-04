/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Sous_transaction;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */
public interface Sous_transactionServices {
    Sous_transaction saveSous_transaction(Sous_transaction e);
    Sous_transaction updateSous_transaction(Sous_transaction e);
    void deleteSous_transaction(Sous_transaction e);
    void deleteSous_transactionById(Long id);
    Sous_transaction getSous_transaction(Long id);
    List<Sous_transaction> getAllSous_transaction();
    
    List<Sous_transaction> findByTAX_SUB_TRANS_NO();
}
