/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 *
 * @author gabri
 */
public class DocController {

    public String leDoc(String nome) {
        String FilePath = nome;
        FileInputStream fis;
        String texto = "";
        if (FilePath.substring(FilePath.length() - 1).equals("x")) { //is a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                XWPFDocument doc = new XWPFDocument(fis);
                XWPFWordExtractor extract = new XWPFWordExtractor(doc);
                System.out.println(extract.getText());
            } catch (IOException e) {

                e.printStackTrace();
            }
        } else { //is not a docx
            try {
                fis = new FileInputStream(new File(FilePath));
                HWPFDocument doc = new HWPFDocument(fis);
                WordExtractor extractor = new WordExtractor(doc);
                texto = extractor.getText();
                System.out.println(texto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return texto;
    }

    public void escreveDoc(String texto, String nome) {
        String logo = "logo-leaf.png";
        String paragraph1 = "poi-word-para1.txt";
        String paragraph2 = "poi-word-para2.txt";
        String paragraph3 = "poi-word-para3.txt";
        String output = nome;

        XWPFDocument document = new XWPFDocument();
        XWPFParagraph title = document.createParagraph();

        title.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun titleRun = title.createRun();
        titleRun.setText("Meu primeiro doc com código e amor");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.CENTER);

        XWPFRun subTitleRun = subTitle.createRun();
        subTitleRun.setText("Cássio Gabriell");
        subTitleRun.setColor("00CC44");
        subTitleRun.setFontFamily("Courier");
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        try {
            FileOutputStream out = new FileOutputStream(output);
            document.write(out);
            out.close();
            document.close();
        } catch (Exception ex) {

        }

    }

    public XWPFDocument substituiDoc(String textoAnterior, String textoPosterior, XWPFDocument doc) {
//        XWPFDocument doc;
        try {
//            doc = new XWPFDocument(OPCPackage.open("teste.docx"));
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
//                        System.out.println(text);

                        if (text != null && text.contains(textoAnterior)) {
                            text = text.replace(textoAnterior, textoPosterior);
                            r.setText(text, 0);
                        }
                    }
                }
            }
//            for (XWPFTable tbl : doc.getTables()) {
//                for (XWPFTableRow row : tbl.getRows()) {
//                    for (XWPFTableCell cell : row.getTableCells()) {
//                        for (XWPFParagraph p : cell.getParagraphs()) {
//                            for (XWPFRun r : p.getRuns()) {
//                                String text = r.getText(0);
//                                if (text != null && text.contains("needle")) {
//                                    text = text.replace("needle", "haystack");
//                                    r.setText(text, 0);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//                doc.write(new FileOutputStream("teste-output.docx"));
        } catch (Exception ex) {

        }
        return doc;
    }
}
