/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.controllers;

import com.impot.comptabilite.models.Type_Budget;
import com.impot.comptabilite.services.Type_BudgetServices;
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
public class Type_BudgetControllers {
    
    @Autowired
    Type_BudgetServices type_budgetService;
    
    @RequestMapping("/ListeType_Budget")
    public String listeType_Budget(ModelMap modelMap) {
        try {

            List<Type_Budget> type_budgets = type_budgetService.getAllType_Budget();
            modelMap.addAttribute("type_budgets", type_budgets);
            return "formType_Budget";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formType_Budget";
    }
}
