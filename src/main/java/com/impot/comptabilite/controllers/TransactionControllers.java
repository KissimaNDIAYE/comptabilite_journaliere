/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.controllers;

import com.impot.comptabilite.models.Transaction;
import com.impot.comptabilite.services.TransactionServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Admin
 */
@Controller
public class TransactionControllers {
    
    @Autowired
    TransactionServices transactionService;
    
    @RequestMapping("/ListeTransaction")
    public String listeTransaction(ModelMap modelMap) {
        try {

            List<Transaction> transactions = transactionService.findByTAX_TRANS_NO();
            modelMap.addAttribute("transactions", transactions);
            return "formTransaction";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formTransaction";
    }
    
}
