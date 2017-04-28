/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.pdf.iText;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Cássio Gabriel
 */
public class TabelaPDF {

    public static void main(String[] args) throws Exception {
        Document doc = null;
        OutputStream os = null;
        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72);
            os = new FileOutputStream("out.pdf");

            PdfWriter.getInstance(doc, os);
            doc.open();
            PdfPTable table = new PdfPTable(3);
            PdfPCell header = new PdfPCell(new Paragraph("Algumas Palavaras Reservadas do Java"));
            header.setColspan(3);
            table.addCell(header);
            table.addCell("abstract");
            table.addCell("extends");
            table.addCell("import");
            table.addCell("while");
            table.addCell("if");
            table.addCell("switch");
            PdfPCell cell4 = new PdfPCell();
            Paragraph p;
            p = new Paragraph(16, "paragraph 1: leading 16");
            cell4.addElement(p);
            p = new Paragraph(32, "paragraph 2: leading 32");
            cell4.addElement(p);
            p = new Paragraph(10, "paragraph 3: leading 10");
            cell4.addElement(p);
            p = new Paragraph(18, "paragraph 4: leading 18");
            cell4.addElement(p);
            p = new Paragraph(40, "paragraph 5: leading 40");
            cell4.addElement(p);
            table.addCell(cell4);
            doc.add(table);
        } catch (DocumentException | ExceptionConverter ex) {
            JOptionPane.showMessageDialog(null, "Falha ao gerar Boletim");
            System.out.println("Erro ao gerar boletim\nErro: " + ex);
        } finally {
            if (doc != null) {
                doc.close();
            }
            if (os != null) {
                os.close();
            }

        }
        Process pro = Runtime.getRuntime().exec("cmd.exe /c  C:\\Users\\Cássio Gabriel\\Documents\\NetBeansProjects\\Testes\\out.pdf");
        pro.waitFor();
    }
}
