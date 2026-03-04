/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.controllers;

import com.impot.comptabilite.models.Sous_transaction;
import com.impot.comptabilite.services.Sous_transactionServices;
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
public class Sous_tansactionControllers {
    
    @Autowired
    Sous_transactionServices transactionService;
    
    @RequestMapping("/ListeSous_transaction")
    public String listeSousTansaction(ModelMap modelMap) {
        try {

            List<Sous_transaction> sous_transactions = transactionService.findByTAX_SUB_TRANS_NO();
            modelMap.addAttribute("sous_transactions", sous_transactions);
            return "formSous_transaction";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formSous_transaction";
    }
    
}
