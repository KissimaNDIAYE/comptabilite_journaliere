/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Entity
@Table(name = "CATEGORIES") // nom exact de la vue dans Oracle
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categorie {
    @Id
    private Long TAX_CATEGORY_NO; // <- clé logique, car Oracle oblige à avoir @Id
    private String TAX_CATEGORY_DESC;
    private String FIXED_VALUE_FL;
}
