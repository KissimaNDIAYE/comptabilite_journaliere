/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.impot.comptabilite.models;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Column;
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
@Table(name = "TRANSACTIONS") 
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    private BigInteger TAX_TRANS_NO; 
    private Long PAYMENT_LOC_NO;
    private Integer PAYMENT_TYPE_NO;
    
    private Long IRD_EMPLOYEE_NO;
    private BigDecimal TAX_CENTRE_NO;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date TRANS_DATE;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date ENTER_DATE;
    
    @Column(name = "ENTER_TIME")
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss") // ou autre format si besoin
    private LocalDateTime ENTER_TIME;

    
    private BigDecimal AMOUNT;
    private BigDecimal BANK_NO;
    private Integer UNDIST_TAX_TYPE_NO;
    private BigInteger DOC_NO;
    private BigInteger ESTAB_NO;
    private BigDecimal PAY_AGREE_NO;
    private BigInteger TAX_ACCOUNT_NO;
    private String UNDIST_LAST_NAME;
    private String UNDIST_FIRST_NAME;
    private String RECEIPT_NO;
    private String TAX_TRANS_COMMENT;
    private BigInteger TAX_PAYER_NO;
    private BigDecimal TAX_TYPE_NO;
    private Long REVERSE_TRANS_NO;
    private Long RECEIPT_DOC_NO;
    private BigDecimal TXN_AMT;
    private Long TXN_CURR_NO;
    private BigDecimal TXN_EXCH_RATE;
    private BigDecimal SEQ_TRANS_NO;
    private BigDecimal RECALC_TRANS_NO;
    private BigDecimal ORIG_TAX_CENTRE_NO;
    private String RECAP_PAY_FL;
    
}
