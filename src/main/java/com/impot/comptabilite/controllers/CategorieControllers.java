/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.controllers;

import com.impot.comptabilite.models.Categorie;
import com.impot.comptabilite.services.CategorieServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Admin
 */
@Controller
public class CategorieControllers {
    
    @Autowired
    CategorieServices categorieService;
    
    @RequestMapping("/ListeCategorie")
    public String listeCategorie(ModelMap modelMap) {
        try {

            List<Categorie> categories = categorieService.getAllCategorie();
            modelMap.addAttribute("categories", categories);
            return "formCategorie";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formCategorie";
    }
    

    // Expose toutes les catégories en JSON
    @GetMapping("/categories")
    @ResponseBody
    public List<Categorie> getCategories() {
        return categorieService.getAllCategorie();
    }

    // Réception du formulaire avec l'ID sélectionné
    @PostMapping("/traiterCategorie")
    public String traiterCategorie(@RequestParam("categorieId") Long id) {
        System.out.println("Catégorie sélectionnée : " + id);
        // Traitement ici (rediriger ou afficher autre vue)
        return "redirect:/confirmation";
    }
}
