/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.repos;

import com.impot.comptabilite.models.Type_Budget;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Admin
 */

public interface Type_BudgetRepository extends JpaRepository<Type_Budget, Long> {
    
}