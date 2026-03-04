/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Type_Budget;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */
public interface Type_BudgetServices {
    Type_Budget saveType_Budget(Type_Budget e);
    Type_Budget updateType_Budget(Type_Budget e);
    void deleteType_Budget(Type_Budget e);
    void deleteType_BudgetById(Long id);
    Type_Budget getType_Budget(Long id);
    List<Type_Budget> getAllType_Budget();
}
