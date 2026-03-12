package com.impot.comptabilite.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.impot.comptabilite.models.MV_Consolide;
import com.impot.comptabilite.services.MV_ConsolideServices;
import com.impot.comptabilite.util.ExcelExportUtil;
import com.impot.comptabilite.util.ExcelExportUtilObjet;
import com.impot.comptabilite.enums.TypeExportMV;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MV_ConsolideController {
    
    @Autowired
    MV_ConsolideServices mvConsolideService;

    @Autowired
    private ExcelExportUtil excelExportUtil;

    @Autowired
    private ExcelExportUtilObjet excelExportUtil1;
    

    MV_ConsolideController(ExcelExportUtil excelExportUtil) {
        this.excelExportUtil = excelExportUtil;
    }
    
    @RequestMapping("/ListeMVConsolide")
    public String listeMVConsolide(ModelMap modelMap) {
        try {

            List<MV_Consolide> mvConsolides = mvConsolideService.recuperMV_Consolides();
            modelMap.addAttribute("mvConsolides", mvConsolides);
            return "formMV_Consolide";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formMV_Consolide";
    }

    @RequestMapping("/ListeMVConsolideImpotDirect")
    public String listeMVConsolideImpotDirect(ModelMap modelMap) {

    try {

        List<Integer> les_mois= mvConsolideService.recuperMois();
        List<Integer> les_annees = mvConsolideService.recuperAnnee();
        List<String> les_structures = mvConsolideService.recuperStructures();
        modelMap.addAttribute("mois", les_mois);
        modelMap.addAttribute("annees", les_annees);
        modelMap.addAttribute("structures", les_structures);

        List<Object[]> mvConsolides = mvConsolideService.recuperImpotDirect(0,0,"");
        List<Object[]> mvConsolidesIndirects = mvConsolideService.recuperImpotIndirect(0,0,"");
        List<Object[]> mvConsolidesDroitEtTimbre = mvConsolideService.recuperDroitEtTimbre(0,0,"");

            double totalMontant = 0.0;

        for (Object[] ligne : mvConsolides) {
            if (ligne[4] != null) {
                totalMontant += Double.parseDouble(ligne[7].toString());
            }
        }

        double totalMontant2 = 0.0;

        for (Object[] ligne : mvConsolidesIndirects) {
            if (ligne[4] != null) {
                totalMontant2 += Double.parseDouble(ligne[7].toString());
            }
        }
        double totalMontant3 = 0.0;

        for (Object[] ligne : mvConsolidesDroitEtTimbre) {
            if (ligne[4] != null) {
                totalMontant3 += Double.parseDouble(ligne[7].toString());
            }
        }

        modelMap.addAttribute("totalMontant", totalMontant);
        modelMap.addAttribute("totalMontant2", totalMontant2);
        modelMap.addAttribute("totalMontant3", totalMontant3);

        modelMap.addAttribute("mvConsolides", mvConsolides);
        modelMap.addAttribute("mvConsolidesIndirects", mvConsolidesIndirects);
        modelMap.addAttribute("mvConsolidesDroitEtTimbre", mvConsolidesDroitEtTimbre);

        return "formMV_Consolide";

    } catch (Throwable e) {

        modelMap.addAttribute("erreur1", e.getMessage());
        modelMap.addAttribute("erreurs", "Une erreur est survenue");
    }

    return "formMV_Consolide";
}
    
    // @RequestMapping("/ListeMVConsolideImpotIndirect")
    // public String listeMVConsolideImpotIndirect(ModelMap modelMap) {
    //     try {

    //         List<MV_Consolide> mvConsolides = mvConsolideService.recuperImpotIndirect();
    //         modelMap.addAttribute("mvConsolides", mvConsolides);
    //         return "formMV_Consolide";
            
    //     } catch (Throwable e) {
    //         String erreur1 = e.getMessage();
    //         String erreurs = "Une erreur est survenue";
            
    //         modelMap.addAttribute("erreur1", erreur1);
    //         modelMap.addAttribute("erreurs", erreurs);
    //     }
    //     return "formMV_Consolide";
    // }
    
    @RequestMapping("/ListeMVConsolideDroitEtTimbre")
    public String listeMVConsolideDroitEtTimbre(ModelMap modelMap) {
        try {

            List<MV_Consolide> mvConsolides = mvConsolideService.recuperDroitEtTimbre();
            modelMap.addAttribute("mvConsolides", mvConsolides);
            return "formMV_Consolide";
            
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formMV_Consolide";
    }

    // 1. Export Impôts Directs
    // @GetMapping("/export/impotDirect")
    // public ResponseEntity<byte[]> exportImpotDirect() throws IOException {
    //     List<MV_Consolide> data = mvConsolideService.recuperImpotDirect();
    //     return excelExportUtil.exportMVConsolides(data, TypeExportMV.IMPOT_DIRECT.getFileName());
    // }

    // 2. Export Impôts Indirects
    // @GetMapping("/export/impotIndirect")
    // public ResponseEntity<byte[]> exportImpotIndirect() throws IOException {
    //     List<MV_Consolide> data = mvConsolideService.recuperImpotIndirect();
    //     return excelExportUtil.exportMVConsolides(data, TypeExportMV.IMPOT_INDIRECT.getFileName());
    // }
    
    // 3. Export Droits et Timbres
    @GetMapping("/export/droitTimbre")
    public ResponseEntity<byte[]> exportDroitTimbre() throws IOException {
        List<MV_Consolide> data = mvConsolideService.recuperDroitEtTimbre();
        return excelExportUtil.exportMVConsolides(data, TypeExportMV.DROIT_TIMBRE.getFileName());
    }

    // 4. Export Données par Structure, Mois et Année
    @GetMapping("/export/donnees")
    public ResponseEntity<byte[]> exportDonnees(
            @RequestParam String structure,
            @RequestParam int mois,
            @RequestParam int annee) throws IOException {
        // List<Object[]> data = mvConsolideService.recuperMV_ConsolidesParStructureMoisAnnee(structure, mois, annee);
        List<Object[]> ID = mvConsolideService.recuperImpotDirect(annee, mois, structure);
        List<Object[]> II = mvConsolideService.recuperImpotIndirect(annee, mois, structure);
        List<Object[]> DT = mvConsolideService.recuperDroitEtTimbre(annee, mois, structure);
        
        
        // return excelExportUtil1.exportMVConsolides(data, TypeExportMV.DONNEES.getFileName());
        return excelExportUtil1.exportMVConsolides(ID, II, DT, TypeExportMV.DONNEES.getFileName());
    }

    @RequestMapping ("/recuperMV_ConsolidesParStructure")
    public String filtreParStructure(@RequestParam String structure, ModelMap modelMap) {
        try {
            List<MV_Consolide> mvConsolides = mvConsolideService.recuperMV_ConsolidesParStructure(structure);
            modelMap.addAttribute("mvConsolides", mvConsolides);
            return "formMV_Consolide";
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formMV_Consolide";
    }

    @RequestMapping ("/recuperMV_ConsolidesParStructureMoisAnnee")
    public String recuperMV_ConsolidesParStructureCodeMoisAnnee(@RequestParam String structure,@RequestParam int mois, @RequestParam int annee,
                                              ModelMap modelMap) {
        try {

            List<Integer> les_mois= mvConsolideService.recuperMois();
            List<Integer> les_annees = mvConsolideService.recuperAnnee();
            List<String> les_structures = mvConsolideService.recuperStructures();
            modelMap.addAttribute("mois", les_mois);
            modelMap.addAttribute("annees", les_annees);
            modelMap.addAttribute("structures", les_structures);


            Integer anneeInt = Integer.valueOf(annee);
            Integer moisInt = Integer.valueOf(mois);
            String structureStr = String.valueOf(structure);
            
            List<Object[]> mvConsolides = mvConsolideService.recuperImpotDirect(anneeInt, moisInt, structureStr);
            List<Object[]> mvConsolidesIndirects = mvConsolideService.recuperImpotIndirect(anneeInt, moisInt, structureStr);
            List<Object[]> mvConsolidesDroitEtTimbre = mvConsolideService.recuperDroitEtTimbre(anneeInt, moisInt, structureStr);

            double totalMontant = 0.0;

            for (Object[] ligne : mvConsolides) {
                if (ligne[4] != null) {
                    totalMontant += Double.parseDouble(ligne[7].toString());
                }
            }

            double totalMontant2 = 0.0;

            for (Object[] ligne : mvConsolidesIndirects) {
                if (ligne[4] != null) {
                    totalMontant2 += Double.parseDouble(ligne[7].toString());
                }
            }
            double totalMontant3 = 0.0;

            for (Object[] ligne : mvConsolidesDroitEtTimbre) {
                if (ligne[4] != null) {
                    totalMontant3 += Double.parseDouble(ligne[7].toString());
                }
            }

            modelMap.addAttribute("totalMontant", totalMontant);
            modelMap.addAttribute("totalMontant2", totalMontant2);
            modelMap.addAttribute("totalMontant3", totalMontant3);

            modelMap.addAttribute("mvConsolides", mvConsolides);
            modelMap.addAttribute("mvConsolidesIndirects", mvConsolidesIndirects);
            modelMap.addAttribute("mvConsolidesDroitEtTimbre", mvConsolidesDroitEtTimbre);
            return "formMV_Consolide";
        } catch (Throwable e) {
            String erreur1 = e.getMessage();
            String erreurs = "Une erreur est survenue";
            
            modelMap.addAttribute("erreur1", erreur1);
            modelMap.addAttribute("erreurs", erreurs);
        }
        return "formMV_Consolide";
    }
    
}