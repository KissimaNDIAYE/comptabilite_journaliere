package com.impot.comptabilite.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.impot.comptabilite.models.MV_Consolide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Component
public class ExcelExportUtil {
    
    public ResponseEntity<byte[]> exportMVConsolides(List<MV_Consolide> data, String fileName) 
            throws IOException {
        
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(fileName);
        
        // Créer l'en-tête
        String[] columns = {"ID", "STRUCTURE", "LOT", "TYPE_LOT", "CODE_LIGNE_IMP", 
                           "CODE_IMPUT", "LIBELLE_COMP_IMP", "MOIS", "ANNEE", 
                           "CATEGORIE_IMPOT", "BUDGET", "MONTANT"};
        
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        
        // Remplir les données
        int rowNum = 1;
        for (MV_Consolide mv : data) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(mv.getId());
            row.createCell(1).setCellValue(mv.getStructure());
            row.createCell(2).setCellValue(mv.getLot());
            row.createCell(3).setCellValue(mv.getTypeLot());
            row.createCell(4).setCellValue(mv.getCodeLigneImp());
            row.createCell(5).setCellValue(mv.getCodeImput());
            row.createCell(6).setCellValue(mv.getLibelleCompImp());
            row.createCell(7).setCellValue(mv.getMois());
            row.createCell(8).setCellValue(mv.getAnnee());
            row.createCell(9).setCellValue(mv.getCategorieImpot());
            row.createCell(10).setCellValue(mv.getBudget());
            row.createCell(11).setCellValue(mv.getMontant().doubleValue());
        }
        
        // Ajuster les colonnes
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }
        
        // Convertir en byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        
        byte[] excelContent = outputStream.toByteArray();
        
        // Configurer la réponse HTTP
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", 
            fileName + "_" + LocalDate.now() + ".xlsx");
        
        return new ResponseEntity<>(excelContent, headers, HttpStatus.OK);
    }
}