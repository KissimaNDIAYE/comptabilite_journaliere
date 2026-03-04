/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Type_Budget;
import com.impot.comptabilite.repos.Type_BudgetRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Service
public class Type_BudgetServicesImpl implements Type_BudgetServices {
    @Autowired
    Type_BudgetRepository type_budgetRepository;
    
    
    @Override
    public Type_Budget saveType_Budget(Type_Budget e) {
        return type_budgetRepository.save(e);
    }

    @Override
    public Type_Budget updateType_Budget(Type_Budget e) {
        return type_budgetRepository.save(e);
    }

    @Override
    public void deleteType_Budget(Type_Budget e) {
        type_budgetRepository.delete(e);
    }

    @Override
    public void deleteType_BudgetById(Long id) {
        type_budgetRepository.deleteById(id);
    }

    @Override
    public Type_Budget getType_Budget(Long id) {
    
        return type_budgetRepository.findById(id).get();
    }
    

    @Override
    public List<Type_Budget> getAllType_Budget() {
        return type_budgetRepository.findAll();
    
    }
}
