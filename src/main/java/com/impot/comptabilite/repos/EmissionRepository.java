/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.repos;

import com.impot.comptabilite.models.Emission;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Admin
 */
public interface EmissionRepository extends JpaRepository<Emission, BigInteger>{
    
    //Recuperer toutes les Emission dont ASSESS_NO < 1000
    @Query("select p from Emission p where p.ASSESS_NO < 1000") 
    List<Emission> findByASSESS_NO();
    
}
