/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.services;

import com.impot.comptabilite.models.Type_Impot;
import java.util.List;

/**
 *
 * @author KISSIMA N'DIAYE
 */
public interface Type_ImpotServices {
    Type_Impot saveType_Impot(Type_Impot e);
    Type_Impot updateType_Impot(Type_Impot e);
    void deleteType_Impot(Type_Impot e);
    void deleteType_ImpotById(Long id);
    Type_Impot getType_Impot(Long id);
    List<Type_Impot> getAllType_Impot();
}
