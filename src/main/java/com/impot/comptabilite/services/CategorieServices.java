/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Categorie;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */
public interface CategorieServices {
    Categorie saveCategorie(Categorie e);
    Categorie updateCategorie(Categorie e);
    void deleteCategorie(Categorie e);
    void deleteCategorieById(Long id);
    Categorie getCategorie(Long id);
    List<Categorie> getAllCategorie();
}
