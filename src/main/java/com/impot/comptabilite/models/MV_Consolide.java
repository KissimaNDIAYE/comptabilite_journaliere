package com.impot.comptabilite.models;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "MV_CONSOLIDES")
public class MV_Consolide {

    @Id
    @Column(name = "ROWID")  // ← Utilise ROWID au lieu d'ID_TECHNIQUE
    private String rowId; // Il est recommandé d'ajouter un ID si la table n'en a pas

    @Column(name = "STRUCTURE", length = 100)
    private String structure;

    @Column(name = "LOT", length = 25)
    private String lot;

    @Column(name = "TYPE_LOT", length = 250)
    private String typeLot;

    @Column(name = "CODE_LIGNE_IMP", length = 30)
    private String codeLigneImp;

    @Column(name = "CODE_IMPUT", length = 50)
    private String codeImput;

    @Column(name = "LIBELLE_COMP_IMP", length = 200)
    private String libelleCompImp;

    @Column(name = "MOIS")
    private Integer mois;

    @Column(name = "ANNEE")
    private Integer annee;

    @Column(name = "CATEGORIE_IMPOT", length = 30)
    private String categorieImpot;

    @Column(name = "BUDGET", length = 30)
    private String budget;

    @Column(name = "MONTANT", precision = 15, scale = 2) // Ajustez selon votre besoin
    private BigDecimal montant;

    // Constructeurs
    public MV_Consolide() {
    }

    public MV_Consolide(String rowId, String structure, String lot, String typeLot, String codeLigneImp, 
                       String codeImput, String libelleCompImp, Integer mois, Integer annee, 
                       String categorieImpot, String budget, BigDecimal montant) {
        this.rowId = rowId;
        this.structure = structure;
        this.lot = lot;
        this.typeLot = typeLot;
        this.codeLigneImp = codeLigneImp;
        this.codeImput = codeImput;
        this.libelleCompImp = libelleCompImp;
        this.mois = mois;
        this.annee = annee;
        this.categorieImpot = categorieImpot;
        this.budget = budget;
        this.montant = montant;
    }

    // Getters et Setters
    public String getId() {
        return rowId;
    }

    public void setId(String rowId) {
        this.rowId = rowId;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getLot() {
        return lot;
    }

    public void setLot(String lot) {
        this.lot = lot;
    }

    public String getTypeLot() {
        return typeLot;
    }

    public void setTypeLot(String typeLot) {
        this.typeLot = typeLot;
    }

    public String getCodeLigneImp() {
        return codeLigneImp;
    }

    public void setCodeLigneImp(String codeLigneImp) {
        this.codeLigneImp = codeLigneImp;
    }

    public String getCodeImput() {
        return codeImput;
    }

    public void setCodeImput(String codeImput) {
        this.codeImput = codeImput;
    }

    public String getLibelleCompImp() {
        return libelleCompImp;
    }

    public void setLibelleCompImp(String libelleCompImp) {
        this.libelleCompImp = libelleCompImp;
    }

    public Integer getMois() {
        return mois;
    }

    public void setMois(Integer mois) {
        this.mois = mois;
    }

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }

    public String getCategorieImpot() {
        return categorieImpot;
    }

    public void setCategorieImpot(String categorieImpot) {
        this.categorieImpot = categorieImpot;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    // equals, hashCode et toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MV_Consolide that = (MV_Consolide) o;
        return Objects.equals(rowId, that.rowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowId);
    }

    @Override
    public String toString() {
        return "MV_Consolide{" +
                "rowId=" + rowId +
                ", structure='" + structure + '\'' +
                ", lot='" + lot + '\'' +
                ", typeLot='" + typeLot + '\'' +
                ", codeLigneImp='" + codeLigneImp + '\'' +
                ", codeImput='" + codeImput + '\'' +
                ", libelleCompImp='" + libelleCompImp + '\'' +
                ", mois=" + mois +
                ", annee=" + annee +
                ", categorieImpot='" + categorieImpot + '\'' +
                ", budget='" + budget + '\'' +
                ", montant=" + montant +
                '}';
    }
}