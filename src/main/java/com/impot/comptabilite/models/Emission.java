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
@Table(name = "EMISSIONS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emission {
    @Id
    private BigInteger ASSESS_NO;
    private Integer ASSESS_TYPE_NO;
    private BigInteger TAX_PAYER_NO;
    private BigDecimal TAX_TYPE_NO;
    private Long TAX_PERIOD_NO;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ENTRY_DATE;
    private String ENTRY_USER;
    private BigInteger ASSESS_NEW_ASSESS_NO;
    private BigDecimal BATCH_NO;
    private BigInteger COLLECTION_CASE_NO;
    private BigInteger ESTAB_NO;
    private BigDecimal A_TAX_TO_PAY;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date RECEPTION_DATE;
    private String PREPARED_BY;
    private BigDecimal TAX_TO_PAY;
    private BigDecimal TAX_PAID;
    private BigDecimal PEN_TO_PAY;
    private BigDecimal PEN_PAID;
    private BigDecimal INT_TO_PAY;
    private BigDecimal INT_PAID;
    private BigDecimal BALANCE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date TP_START_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date TP_END_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date TP_DUE_DATE;
    private String ASSESS_COMMENT;
    private Integer CALC_STATUS_NO;
    private Long LIC_BASE_NO;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date INT_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date PAY_PEN_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date FILE_PEN_DATE;
    private Integer FORM_NO;
    private Integer VERSION_NO;
    private BigDecimal LAST_TAX_BALANCE;
    private BigDecimal LAST_PEN_BALANCE;
    private BigDecimal LAST_INT_BALANCE;
    private BigDecimal PLAST_TAX_BALANCE;
    private BigDecimal PLAST_PEN_BALANCE;
    private BigDecimal PLAST_INT_BALANCE;
    private BigDecimal TAX_CENTRE_NO;
    private BigInteger LICENSE_NO;
    private BigInteger TAX_ACCOUNT_NO;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date TP_PAYMENT_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date INT_DATE_TEMP;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date LAST_PEN_INT_CALC_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date LAST_CALC_DATE;

    private Long TRIGGERING_ASSESS_NO;
    private Integer REASSESS_RQST_EMPLEE_NO;
    private Integer REASSESS_REASON_NO;
    private Long RANGE_START_TAX_PERIOD_NO;
    private String REASSESS_AUTH_FL;
    private BigInteger SUPPORT_DOC_NO;
    private BigInteger TAXABLE_OBJECT_NO;
    private Long COLLECTION_LOCATION_NO;
    private Integer LETTER_NO;
    private Long LIC_RATE_NO;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date REASS_CREATION_DATE;
    private String ASSESS_COMMENT_1;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date UPDATE_DATE;
    private Long UPDATE_USER;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ETAX_SUBM_TMSTMP;
    private String ETAX_SUBM_ID;
    private Long CURRENCY_NO;
    private BigDecimal EXCH_RATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date LAST_GET_BAL_CALC_DATE;
    private BigDecimal TAX_CREDIT;
    private BigDecimal PEN_CREDIT;
    private BigDecimal INT_CREDIT;
    private BigDecimal TAX_PAYM;
    private BigDecimal PEN_PAYM;
    private BigDecimal INT_PAYM;
    private BigDecimal OVER_PAYM;
    private BigDecimal OVER_CREDIT;
    private String DISTRIB_UPTODATE_FL;
    private BigDecimal ASSESS_OVER_PAYM;
    private BigDecimal ASSESS_OVER_CREDIT;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ASSESS_TRANS_DATE;
    private BigDecimal PROP_PART_NO;
    private String ASSESS_NO_REMITT_FL;
    private BigDecimal ORIG_TAX_CENTRE_NO;
    private BigDecimal TXBL_OBJ_ACTION_OWNER_NO;
    private String TAXPAYER_CONSENT_FL;
    private Long NON_TAXPYR_NO;
    private Long WORKER_COUNT;
    private String WORKER_COUNT_DESC;
    private String ETAX_CALCULATION_TEST_FL;
    private String ETAX_SUBM_USER;
    private String ETAX_SUBM_USER_ID;
    private BigDecimal ETAX_DECL_SUBM_ID;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date LAST_PEN_INT_CALC_TIME;

}
