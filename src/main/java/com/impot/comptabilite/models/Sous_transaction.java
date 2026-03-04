/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author KISSIMA N'DIAYE
 */
@Entity
@Table(name = "SOUS_TRANSACTIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sous_transaction {
    private String AUTO_GEN_FLAG;
    private Long PEN_NO;
    private Long INT_NO;
    private Long JOB_NO;
    private Long LIC_BASE_NO;
    private BigInteger ESTAB_NO;
    private BigInteger TAX_ACCOUNT_NO;
    private BigDecimal TAX_CENTRE_NO;
    private BigDecimal TAX_TYPE_NO;
    private BigInteger LICENSE_NO;
    private String SET_BY_CAPT_REM;
    private String SET_BY_MOD;
    private Long CREDIT_SOURCE_TYPE_NO;
    private Long INST_ASSESS_NO;
    private String INST_TRANSFER_FLAG;
    private String APPEAL_DEPOSIT_FL;
    private Long REVENUE_CODE_NO;
    private Long REFUND_NO;
    private Long TRANSFER_TAX_TYPE_NO;
    private Long TRANSFER_ASSESS_NO;
    private Long TAX_AUTH_NO;
    private String COMMON_REVENUE;
    private BigInteger TAXABLE_OBJECT_NO;
    private Long COLLECTION_LOCATION_NO;
    private Long BASE_AMT_MULTIPLIER;
    private BigDecimal PI_CALC_BASE_AMT;
    private Long PI_WORKDAYS_COUNT;
    private BigDecimal TXN_AMT;
    private Long TXN_CURR_NO;
    private BigDecimal TXN_EXCH_RATE;
    private BigDecimal SEQ_TRANS_NO;
    private BigDecimal SEQ_NO;
    private String REVERSE_FOREGONE_FL;
    private Long CHARGE_TYPE_GROUP_NO;
    private BigDecimal WRITE_OFF_TYPE_NO;
    private BigDecimal OBJECTION_NO;
    private String OPEN_BAL_REF_NO;
    private BigDecimal ORIG_TAX_CENTRE_NO;
    private Long AUDIT_CASE_NO;
    private BigDecimal TRANSFER_FROM_SUB_TRANS_NO;
    private BigDecimal TRANSFER_OUT_CORRESP_SUB_TRANS;
    private BigInteger TAX_SUB_TRANS_NO;
    @Id
    private Long CHARGE_TYPE_NO;
    private Long TAX_TRANS_TYPE_NO;
    private BigInteger TAX_TRANS_NO;
    private BigDecimal AMOUNT;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ENTER_DATE ;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ENTER_TIME ;
    private BigDecimal TAXTR_COM_NO;
    private Long TAX_PERIOD_NO;
    private BigInteger ASSESS_NO;
    private String ARREARS_FLAG;
    private String REVERSE_FLAG;
    private BigInteger REVERSE_TRANS_NO;
    private String SUB_TRANS_COMMENT;

}
