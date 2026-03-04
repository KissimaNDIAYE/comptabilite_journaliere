package com.impot.comptabilite.dto;

import java.math.BigDecimal;

public class LigneSituationDTO {
    private String compteImputation;
    private String libelle;
    private BigDecimal prisesEnChargeAnterieures;
    private BigDecimal prisesEnChargeMois;
    private BigDecimal totalPrisesEnCharge;
    private BigDecimal decharges;
    private BigDecimal prisesEnChargeNettes;
    private BigDecimal recouvrementsAnterieurs;
    private BigDecimal recouvrementsMois;
    private BigDecimal totalRecouvrements;
    private BigDecimal restesARecouvrer;
    private String observations;

    // Constructeurs
    public LigneSituationDTO() {
        this.prisesEnChargeAnterieures = BigDecimal.ZERO;
        this.prisesEnChargeMois = BigDecimal.ZERO;
        this.totalPrisesEnCharge = BigDecimal.ZERO;
        this.decharges = BigDecimal.ZERO;
        this.prisesEnChargeNettes = BigDecimal.ZERO;
        this.recouvrementsAnterieurs = BigDecimal.ZERO;
        this.recouvrementsMois = BigDecimal.ZERO;
        this.totalRecouvrements = BigDecimal.ZERO;
        this.restesARecouvrer = BigDecimal.ZERO;
    }

    // Getters et Setters
    public String getCompteImputation() { return compteImputation; }
    public void setCompteImputation(String compteImputation) { this.compteImputation = compteImputation; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public BigDecimal getPrisesEnChargeAnterieures() { return prisesEnChargeAnterieures; }
    public void setPrisesEnChargeAnterieures(BigDecimal prisesEnChargeAnterieures) { 
        this.prisesEnChargeAnterieures = prisesEnChargeAnterieures; 
    }

    public BigDecimal getPrisesEnChargeMois() { return prisesEnChargeMois; }
    public void setPrisesEnChargeMois(BigDecimal prisesEnChargeMois) { 
        this.prisesEnChargeMois = prisesEnChargeMois; 
    }

    public BigDecimal getTotalPrisesEnCharge() { return totalPrisesEnCharge; }
    public void setTotalPrisesEnCharge(BigDecimal totalPrisesEnCharge) { 
        this.totalPrisesEnCharge = totalPrisesEnCharge; 
    }

    public BigDecimal getDecharges() { return decharges; }
    public void setDecharges(BigDecimal decharges) { this.decharges = decharges; }

    public BigDecimal getPrisesEnChargeNettes() { return prisesEnChargeNettes; }
    public void setPrisesEnChargeNettes(BigDecimal prisesEnChargeNettes) { 
        this.prisesEnChargeNettes = prisesEnChargeNettes; 
    }

    public BigDecimal getRecouvrementsAnterieurs() { return recouvrementsAnterieurs; }
    public void setRecouvrementsAnterieurs(BigDecimal recouvrementsAnterieurs) { 
        this.recouvrementsAnterieurs = recouvrementsAnterieurs; 
    }

    public BigDecimal getRecouvrementsMois() { return recouvrementsMois; }
    public void setRecouvrementsMois(BigDecimal recouvrementsMois) { 
        this.recouvrementsMois = recouvrementsMois; 
    }

    public BigDecimal getTotalRecouvrements() { return totalRecouvrements; }
    public void setTotalRecouvrements(BigDecimal totalRecouvrements) { 
        this.totalRecouvrements = totalRecouvrements; 
    }

    public BigDecimal getRestesARecouvrer() { return restesARecouvrer; }
    public void setRestesARecouvrer(BigDecimal restesARecouvrer) { 
        this.restesARecouvrer = restesARecouvrer; 
    }

    public String getObservations() { return observations; }
    public void setObservations(String observations) { this.observations = observations; }
}