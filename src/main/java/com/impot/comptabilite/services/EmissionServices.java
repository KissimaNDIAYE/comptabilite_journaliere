/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Emission;

import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */
public interface EmissionServices {
    Emission saveEmission(Emission e);
    Emission updateEmission(Emission e);
    void deleteEmission(Emission e);
    void deleteEmissionById(BigInteger id);
    Emission getEmission(BigInteger id);
    List<Emission> getAllEmission();
    
    List<Emission> findByASSESS_NO();
}
