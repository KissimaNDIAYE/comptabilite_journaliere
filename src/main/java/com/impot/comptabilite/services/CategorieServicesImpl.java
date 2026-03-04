/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Categorie;
import com.impot.comptabilite.repos.CategorieRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class CategorieServicesImpl implements CategorieServices {
    @Autowired
    CategorieRepository categorieRepository;
    
    
    @Override
    public Categorie saveCategorie(Categorie e) {
        return categorieRepository.save(e);
    }

    @Override
    public Categorie updateCategorie(Categorie e) {
        return categorieRepository.save(e);
    }

    @Override
    public void deleteCategorie(Categorie e) {
        categorieRepository.delete(e);
    }

    @Override
    public void deleteCategorieById(Long id) {
        categorieRepository.deleteById(id);
    }

    @Override
    public Categorie getCategorie(Long id) {
    
        return categorieRepository.findById(id).get();
    }
    

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepository.findAll();
    
    }
}
