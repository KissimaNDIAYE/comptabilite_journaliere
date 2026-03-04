/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.controllers;

import com.impot.comptabilite.models.Type_Impot;
import com.impot.comptabilite.services.Type_ImpotServices;
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
public class Type_ImpotControllers {
    
    @Autowired
    Type_ImpotServices type_impotService;
    
    @RequestMapping("/ListeType_Impot")
    public String listeType_Impot(ModelMap modelMap) {
        try {

            List<Type_Impot> type_impots = type_impotService.getAllType_Impot();
            modelMap.addAttribute("type_impots", type_impots);
            return "formType_Impot";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formType_Impot";
    }
}
