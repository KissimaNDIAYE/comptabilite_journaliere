package com.impot.comptabilite.util;

// Import Apache POI pour manipuler Excel
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Import Spring pour retourner un fichier téléchargeable
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

// Import Java
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component // Permet à Spring de gérer automatiquement cette classe
public class ExcelExportUtilObjet {

    public ResponseEntity<byte[]> exportMVConsolides(
            List<Object[]> impotsDirect,
            List<Object[]> impotsIndirect,
            List<Object[]> droitsTimbres,
            String fileName) throws IOException {

        // Création du fichier Excel
        Workbook workbook = new XSSFWorkbook();

        // Création de la feuille
        Sheet sheet = workbook.createSheet("MV_Consolides");

        /* =========================
           CREATION DES STYLES
        ========================= */

        // Style entête colonnes
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short)12);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        setBorder(headerStyle);

        // Style cellule normale
        CellStyle normalStyle = workbook.createCellStyle();
        setBorder(normalStyle);

        // Style montant
        CellStyle montantStyle = workbook.createCellStyle();
        montantStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0"));
        setBorder(montantStyle);

        // Style sous-total
        Font subtotalFont = workbook.createFont();
        subtotalFont.setBold(true);

        CellStyle subtotalStyle = workbook.createCellStyle();
        subtotalStyle.setFont(subtotalFont);
        subtotalStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        subtotalStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        subtotalStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0"));
        setBorder(subtotalStyle);

        // Style grand total
        Font totalFont = workbook.createFont();
        totalFont.setBold(true);
        totalFont.setFontHeightInPoints((short)14);

        CellStyle totalStyle = workbook.createCellStyle();
        totalStyle.setFont(totalFont);
        totalStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        totalStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        totalStyle.setDataFormat(workbook.createDataFormat().getFormat("#,##0"));
        setBorder(totalStyle);

        // Style titre catégorie
        Font categorieFont = workbook.createFont();
        categorieFont.setBold(true);
        categorieFont.setFontHeightInPoints((short)13);

        CellStyle categorieStyle = workbook.createCellStyle();
        categorieStyle.setFont(categorieFont);
        // categorieStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        // categorieStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        setBorder(categorieStyle);

        /* =========================
           ENTETE DU TABLEAU
        ========================= */

        String[] columns = {
                "STRUCTURE",
                "CODE_IMPUT",
                "LIBELLE_COMP_IMP",
                "MOIS",
                "ANNEE",
                "CATEGORIE_IMPOT",
                "BUDGET",
                "MONTANT"
        };

        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {

            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerStyle);

        }

        /* =========================
           COMBINAISON DES DONNEES
        ========================= */

        List<Object[]> allData = new ArrayList<>();

        allData.addAll(impotsDirect);
        allData.addAll(impotsIndirect);
        allData.addAll(droitsTimbres);

        /* =========================
           TRI DES DONNEES
        ========================= */

        allData.sort(Comparator
                .comparing((Object[] o) -> ordreCategorie(o[5] != null ? o[5].toString() : ""))
                .thenComparing(o -> o[1] != null ? o[1].toString() : ""));

        /* =========================
           REMPLISSAGE DU TABLEAU
        ========================= */

        int rowNum = 1;

        String currentCategory = null;

        double subtotal = 0;

        double grandTotal = 0;

        for (Object[] ligne : allData) {

            String categorie = ligne[5] != null ? ligne[5].toString() : "";

            double montant = ligne[7] != null
                    ? ((Number) ligne[7]).doubleValue()
                    : 0;

            // Si changement de catégorie
            if (!categorie.equals(currentCategory)) {

                // Afficher sous total de la catégorie précédente
                if (currentCategory != null) {

                    Row subtotalRow = sheet.createRow(rowNum++);

                    Cell label = subtotalRow.createCell(6);
                    // label.setCellValue("Sous-total " + currentCategory);
                    label.setCellStyle(subtotalStyle);

                    Cell value = subtotalRow.createCell(7);
                    value.setCellValue(subtotal);
                    value.setCellStyle(subtotalStyle);

                    subtotal = 0;
                }

                // Ligne titre catégorie
                Row categorieRow = sheet.createRow(rowNum++);

                Cell cell = categorieRow.createCell(0);
                cell.setCellValue(titreCategorie(categorie));
                cell.setCellStyle(categorieStyle);

                // Fusion des colonnes
                sheet.addMergedRegion(new CellRangeAddress(
                        categorieRow.getRowNum(),
                        categorieRow.getRowNum(),
                        0,
                        7
                ));
            }

            // Création ligne données
            Row row = sheet.createRow(rowNum++);

            createCell(row,0,ligne[0],normalStyle);
            createCell(row,1,ligne[1],normalStyle);
            createCell(row,2,ligne[2],normalStyle);
            createCell(row,3,ligne[3],normalStyle);
            createCell(row,4,ligne[4],normalStyle);
            createCell(row,5,categorie,normalStyle);
            createCell(row,6,ligne[6],normalStyle);

            Cell montantCell = row.createCell(7);
            montantCell.setCellValue(montant);
            montantCell.setCellStyle(montantStyle);

            subtotal += montant;
            grandTotal += montant;

            currentCategory = categorie;
        }

        /* =========================
           DERNIER SOUS TOTAL
        ========================= */

        if (currentCategory != null) {

            Row subtotalRow = sheet.createRow(rowNum++);

            Cell label = subtotalRow.createCell(6);
            // label.setCellValue("Sous-total " + currentCategory);
            label.setCellStyle(subtotalStyle);

            Cell value = subtotalRow.createCell(7);
            value.setCellValue(subtotal);
            value.setCellStyle(subtotalStyle);
        }

        /* =========================
           GRAND TOTAL
        ========================= */

        Row totalRow = sheet.createRow(rowNum++);

        Cell totalLabel = totalRow.createCell(6);
        totalLabel.setCellValue("TOTAL BUDGET NATIONAL");
        totalLabel.setCellStyle(totalStyle);

        Cell totalValue = totalRow.createCell(7);
        totalValue.setCellValue(grandTotal);
        totalValue.setCellStyle(totalStyle);

        /* =========================
           AJUSTEMENT DES COLONNES
        ========================= */

        for (int i = 0; i < columns.length; i++) {

            sheet.autoSizeColumn(i);

        }

        /* =========================
           GENERATION DU FICHIER
        ========================= */

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        workbook.write(outputStream);

        workbook.close();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        headers.setContentDispositionFormData(
                "attachment",
                fileName + "_" + LocalDate.now() + ".xlsx"
        );

        return new ResponseEntity<>(
                outputStream.toByteArray(),
                headers,
                HttpStatus.OK
        );
    }

    /* =========================
       TITRE DES CATEGORIES
    ========================= */

    private String titreCategorie(String categorie) {

        if (categorie == null) return "";

        switch (categorie) {

            case "IMPOTS DIRECTS":
                return "A - IMPOTS DIRECTS";

            case "IMPOTS INDIRECTS":
                return "B - IMPOTS INDIRECTS";

            case "DROITS ET TIMBRES":
                return "C - DROITS D'ENREGISTREMENT ET DE TIMBRE";

            default:
                return categorie;
        }
    }

    /* =========================
       ORDRE DES CATEGORIES
    ========================= */

    private int ordreCategorie(String categorie) {

        if (categorie == null) return 4;

        switch (categorie) {

            case "IMPOTS DIRECTS":
                return 1;

            case "IMPOTS INDIRECTS":
                return 2;

            case "DROITS ET TIMBRES":
                return 3;

            default:
                return 4;
        }
    }

    /* =========================
       CREATION CELLULE
    ========================= */

    private void createCell(Row row, int column, Object value, CellStyle style) {

        Cell cell = row.createCell(column);

        cell.setCellValue(value != null ? value.toString() : "");

        cell.setCellStyle(style);
    }

    /* =========================
       BORDURES
    ========================= */

    private void setBorder(CellStyle style) {

        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
    }
}