package com.impot.comptabilite.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "MV_PAIEMENT")
public class MV_Paiement {

    @Id
    @Column(name = "ROWID")  // Utilisation de ROWID d'Oracle comme identifiant
    private String rowId;

    @Column(name = "DATE_DU_PAIEMENT")
    @Temporal(TemporalType.DATE)
    private Date dateDuPaiement;

    @Column(name = "HEURE_DU_PAIEMENT", length = 5)
    private String heureDuPaiement;

    @Column(name = "NUMERO_FISCAL", length = 20)
    private String numeroFiscal;

    @Column(name = "PARTIE_VERSANTE", length = 602)
    private String partieVersante;

    @Column(name = "NO_RECU", length = 10)
    private String noRecu;

    @Column(name = "MONTANT", precision = 30, scale = 2)
    private BigDecimal montant;

    @Column(name = "MODE_DE_PAIEMENT", length = 250)
    private String modeDePaiement;

    @Column(name = "NO_COMPTE_IMPOT", precision = 25, scale = 0)
    private Long noCompteImpot;

    @Column(name = "TYPE_DE_TRANSACTION", length = 20)
    private String typeDeTransaction;

    @Column(name = "NATURE", length = 20)
    private String nature;

    @Column(name = "CENTRE_DE_PAIEMENT", length = 2000)
    private String centreDePaiement;

    @Column(name = "TYPE_IMPOT", length = 100)
    private String typeImpot;

    @Column(name = "MOIS_IMPOSITION", precision = 2, scale = 0)
    private Integer moisImposition;

    @Column(name = "ANNEE_IMPOSITION", precision = 4, scale = 0)
    private Integer anneeImposition;

    // Constructeurs
    public MV_Paiement() {
    }

    public MV_Paiement(String rowId, Date dateDuPaiement, String heureDuPaiement, String numeroFiscal, 
                      String partieVersante, String noRecu, BigDecimal montant, String modeDePaiement, 
                      Long noCompteImpot, String typeDeTransaction, String nature, String centreDePaiement, 
                      String typeImpot, Integer moisImposition, Integer anneeImposition) {
        this.rowId = rowId;
        this.dateDuPaiement = dateDuPaiement;
        this.heureDuPaiement = heureDuPaiement;
        this.numeroFiscal = numeroFiscal;
        this.partieVersante = partieVersante;
        this.noRecu = noRecu;
        this.montant = montant;
        this.modeDePaiement = modeDePaiement;
        this.noCompteImpot = noCompteImpot;
        this.typeDeTransaction = typeDeTransaction;
        this.nature = nature;
        this.centreDePaiement = centreDePaiement;
        this.typeImpot = typeImpot;
        this.moisImposition = moisImposition;
        this.anneeImposition = anneeImposition;
    }

    // Getters et Setters
    public String getRowId() {
        return rowId;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public Date getDateDuPaiement() {
        return dateDuPaiement;
    }

    public void setDateDuPaiement(Date dateDuPaiement) {
        this.dateDuPaiement = dateDuPaiement;
    }

    public String getHeureDuPaiement() {
        return heureDuPaiement;
    }

    public void setHeureDuPaiement(String heureDuPaiement) {
        this.heureDuPaiement = heureDuPaiement;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public void setNumeroFiscal(String numeroFiscal) {
        this.numeroFiscal = numeroFiscal;
    }

    public String getPartieVersante() {
        return partieVersante;
    }

    public void setPartieVersante(String partieVersante) {
        this.partieVersante = partieVersante;
    }

    public String getNoRecu() {
        return noRecu;
    }

    public void setNoRecu(String noRecu) {
        this.noRecu = noRecu;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getModeDePaiement() {
        return modeDePaiement;
    }

    public void setModeDePaiement(String modeDePaiement) {
        this.modeDePaiement = modeDePaiement;
    }

    public Long getNoCompteImpot() {
        return noCompteImpot;
    }

    public void setNoCompteImpot(Long noCompteImpot) {
        this.noCompteImpot = noCompteImpot;
    }

    public String getTypeDeTransaction() {
        return typeDeTransaction;
    }

    public void setTypeDeTransaction(String typeDeTransaction) {
        this.typeDeTransaction = typeDeTransaction;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getCentreDePaiement() {
        return centreDePaiement;
    }

    public void setCentreDePaiement(String centreDePaiement) {
        this.centreDePaiement = centreDePaiement;
    }

    public String getTypeImpot() {
        return typeImpot;
    }

    public void setTypeImpot(String typeImpot) {
        this.typeImpot = typeImpot;
    }

    public Integer getMoisImposition() {
        return moisImposition;
    }

    public void setMoisImposition(Integer moisImposition) {
        this.moisImposition = moisImposition;
    }

    public Integer getAnneeImposition() {
        return anneeImposition;
    }

    public void setAnneeImposition(Integer anneeImposition) {
        this.anneeImposition = anneeImposition;
    }

    // equals, hashCode et toString
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MV_Paiement that = (MV_Paiement) o;
        return Objects.equals(rowId, that.rowId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowId);
    }

    @Override
    public String toString() {
        return "MvPaiement{" +
                "rowId='" + rowId + '\'' +
                ", dateDuPaiement=" + dateDuPaiement +
                ", heureDuPaiement='" + heureDuPaiement + '\'' +
                ", numeroFiscal='" + numeroFiscal + '\'' +
                ", partieVersante='" + partieVersante + '\'' +
                ", noRecu='" + noRecu + '\'' +
                ", montant=" + montant +
                ", modeDePaiement='" + modeDePaiement + '\'' +
                ", noCompteImpot=" + noCompteImpot +
                ", typeDeTransaction='" + typeDeTransaction + '\'' +
                ", nature='" + nature + '\'' +
                ", centreDePaiement='" + centreDePaiement + '\'' +
                ", typeImpot='" + typeImpot + '\'' +
                ", moisImposition=" + moisImposition +
                ", anneeImposition=" + anneeImposition +
                '}';
    }
}