/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.models;

import java.math.BigDecimal;
import javax.persistence.Column;
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
@Table(name = "TYPE_IMPOTS") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type_Impot {
    @Id
    @Column(name = "TAX_TYPE_NO")
    private Long TAX_TYPE_NO; 
    private Integer TAX_BASIS_NO;
    @Column(name = "TAX_TYPE_DESC")
    private String TAX_TYPE_DESC;
    private String IS_LICENSE;
    private Long BUDGET_TYPE_NO;
    private String USE_CRITERIA;
    private String INSTALL_BY_DEF;
    private String REFUND_BY_DEF;
    private String ASSESS_NOTICE_ONLY;
    private String PRINT_TRADE_NAME;
    private String CONSOLIDATED;
    private BigDecimal IS_VAT;
    private BigDecimal IS_INSTALMENT;
    private BigDecimal HAS_INSTALMENT;
    private String IN_STAT_REPORT;
    private String USE_REVENUE_CODE;
    private String TAX_ACCT_BY_DEF_FL;
    private BigDecimal DEF_INST_RANGE_NO;
    private BigDecimal TAX_TYPE_REFERENCE_NO;
    private String IS_TAXABLE_OBJECT_FL;
    private String IS_PROP_TRANSFER_FL;
    private String IS_PROP_EXEMPTION_FL;
    private BigDecimal CREDIT_REFUNDABLE_MONTH;
    private BigDecimal CERTIFICATE_MIN_AMOUNT;
    private BigDecimal INCOME_TYPE_NO;
    private String USE_RATE_ZONE_FL;
    private String USES_LOSS_FL;
    private String DOC_CODE;
    private String ALLOW_MULTIPLE_TAX_ACCOUNTS;
    private BigDecimal INTERMITTENT_OPTION_FL;
    private String ALLOW_MANY_ACTIVE_ACCT_FL;
    private BigDecimal DISTRIBUTE_AMT_BY_NO;
    private String NON_FISCAL_REVENUE_FL;
    private BigDecimal INITIAL_SUSPENSION;
    private BigDecimal DELAY_DORMANCY;
    private String ALLOW_ASSESS_FCY;
    private BigDecimal CURRENCY_NO;
    private String TAX_AGENT_PGM_FL;
    private String USED_BY_ETAX_FL;
    private String CFWD_PAYM_WITH_CREDIT_FL;
    private String DISTRIB_CF_ON_TAX_ONLY_FL;
    private String AUTO_CARRY_FWD_FL;
    private String EXT_TAX_CODE;
    private String SUSPENDED_TAX;
    private String EXEMPTED_TAX;
    private String APPLY_DUE_DT_YRBF_FL;
    private String IMM_ASSESS_LP_FL;
    private String USES_CREDIT_FL;
    private String ALLOW_MULTI_TAX_TYPE_CENTRE;
    private BigDecimal TAX_CATEGORY_NO;
    private String TAX_PERIOD_MANDATORY_FL;
    private String PEN_INT_CALCS_INCLUDE_CREDIT;
    private String TAX_TYPE_CODE;
    private BigDecimal LEASE_TYPE_NO;
    private BigDecimal PAYMENT_FREQ_NO;
    private String MUST_ENTER_TIN_FOR_IMMED_ASSM;
    private String BYPASS_TCC_FL;
    private String THIRD_PARTY_FL;
    private BigDecimal LICENSE_TYPE_NO;
    private String AUTO_ASSES_CREATE_FL;
    @Column(nullable = true)
    private String LIC_BASE_AS_ENT_ACTIVITY_FL;
    @Column(nullable = true)
    private Long PAYMENT_BASED_ON;
    private String CAR_TAX_STICKER_FL;
    private String STAMP_FL;
    private String FEE_CERTIFICATE_FL;
    
}
