package com.impot.comptabilite.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.impot.comptabilite.models.MV_Paiement;
import com.impot.comptabilite.services.MV_PaiementServices;

@Controller
public class MV_PaiementController {
    
    @Autowired
    MV_PaiementServices mvPaiementService;
    
    @RequestMapping("/ListeMVPaiement")
    public String listeMVPaiement(ModelMap modelMap) {
        try {

            List<MV_Paiement> mvPaiements = mvPaiementService.recuperMV_Paiements();
            modelMap.addAttribute("mvPaiements", mvPaiements);
            return "formMV_Paiement";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formMV_Paiement";
    }
    
}