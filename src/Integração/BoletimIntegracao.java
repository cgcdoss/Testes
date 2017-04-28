/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Integração;

import iText.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Cássio Gabriel
 */
public class BoletimIntegracao {

    public static void main(String[] args) throws Exception {
        Document doc = null;
        OutputStream os = null;
        try {
            doc = new Document(PageSize.A4, 72, 72, 72, 72); //1-?, 2-?, 3-Cima, 4-?
            os = new FileOutputStream("Boletim.pdf");

            PdfWriter.getInstance(doc, os);
            doc.open();

            Font f = new Font(FontFamily.COURIER, 24, Font.BOLD); //Definição de uma fonte - Títulos
            Font f1 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, BaseColor.GRAY); //Escola Conquista
            Font f2 = new Font(FontFamily.TIMES_ROMAN, 12, Font.NORMAL); //Fonte Normal
            Font f3 = new Font(FontFamily.UNDEFINED, 12, Font.BOLD); //Fonte Normal
//            doc.add(new Paragraph("HISTÓRICO ESCOLAR", f)); //Outra maneira de criar um parágrafo
            Paragraph p1 = new Paragraph("BOLETIM ESCOLAR", f); //Criação de um parágrafo utilizando uma fonte criada (f)
            p1.setAlignment(Element.ALIGN_CENTER); //Alinhamento
            p1.setLeading(30, 0); //Espaço entre linhas
            doc.add(p1); //Adicionando parágrafo ao documento

            Paragraph p3 = new Paragraph("Escola Conquista", f1);
            p3.setAlignment(Element.ALIGN_CENTER);
            doc.add(p3);

            PdfPTable table = new PdfPTable(4); //Criando uma table, passando como parâmetro o nº de colunas
            table.setWidthPercentage(100); //Define o tamanho da table em %
            table.setSpacingBefore(10); //Define o espaço antes da table
            table.setSpacingAfter(10); //Define o espaço depois da table
            PdfPCell header = new PdfPCell(); //Criando uma célula header
            Paragraph p2 = new Paragraph("Dados da Escola"); //Criando Parágrafo pra entrar no header da table
            header.addElement(p2); //Adicionando parágrafo ao header
            p2.setAlignment(Element.ALIGN_CENTER); //Definindo alinhamento do parágrafo
            header.setColspan(4); //Definindo colspan para o header
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(header); //Adicionando o header à table

            PdfPCell cell1 = new PdfPCell(new Phrase("Nome da Escola: ")); //Criando uma célula
            cell1.setColspan(4); //Definindo colspan para a célula
            table.addCell(cell1); //Adicionando célula à table

            PdfPCell cell2 = new PdfPCell(new Phrase("Endereço da escola: "));
            cell2.setColspan(4);
            table.addCell(cell2);

            table.addCell("Bairro: ");

            PdfPCell cell3 = new PdfPCell(new Phrase("Município: "));
            cell3.setColspan(2);
            table.addCell(cell3);

            table.addCell("UF: "); //Criando uma célula de modo diferente
            table.addCell("while");
            table.addCell("if");
            table.addCell("switch");

//            for (int i = 0; i < 8; i++) {
//            table.completeRow(); //Exibe uma linha, mesmo que inocompleta
//            Tabela 2
            PdfPTable table2 = new PdfPTable(20);
            table2.setSpacingBefore(10);
            table2.setSpacingAfter(10);
            table2.setWidthPercentage(100);
            PdfPCell header2 = new PdfPCell();

            Paragraph p4 = new Paragraph("Dados do Aluno");
            header2.addElement(p4); //Geralmente deixa um espaço vertical maior
            p4.setAlignment(Element.ALIGN_CENTER);
            header2.setColspan(20);
            header2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table2.addCell(header2);

            PdfPCell cell4 = new PdfPCell(new Phrase("Nome do aluno: "));
            cell4.setColspan(20);
            table2.addCell(cell4);

            PdfPCell cell5 = new PdfPCell(new Phrase("Data de Nascimento: "));
            cell5.setColspan(8);
            table2.addCell(cell5);

            PdfPCell cell6 = new PdfPCell(new Phrase("Cidade: "));
            cell6.setColspan(8);
            table2.addCell(cell6);

            PdfPCell cell7 = new PdfPCell(new Phrase("UF: "));
            cell7.setColspan(4);
            table2.addCell(cell7);

            PdfPCell cell8 = new PdfPCell(new Phrase("Filiação", f3));
            cell8.setColspan(2);
            cell8.setRowspan(2);
            cell8.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table2.addCell(cell8);

            PdfPCell cell9 = new PdfPCell(new Phrase("Mãe: "));
            cell9.setColspan(18);
            table2.addCell(cell9);

            PdfPCell cell10 = new PdfPCell(new Phrase("Pai: "));
            cell10.setColspan(18);
            table2.addCell(cell10);

//            Tabela 3
            PdfPTable table3 = new PdfPTable(22);
            table3.setSpacingBefore(10);
            table3.setSpacingAfter(10);
            table3.setWidthPercentage(100);
            PdfPCell header3 = new PdfPCell();

            Paragraph p5 = new Paragraph("Componentes Curriculares");
            p5.setAlignment(Element.ALIGN_CENTER);
            header3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header3.addElement(p5);
            header3.setColspan(22);
            table3.addCell(header3);

            PdfPCell cell12 = new PdfPCell();
            cell12.addElement(new Phrase("Avaliações", f3));
            cell12.setColspan(4);
            table3.addCell(cell12);

//            Aqui complica...
//            Aqui é montado o subcabeçalho da 3º tabela
            int i = 1;
            while (i < 7) {
                PdfPCell cell;
                if (i == 3) {
                    cell = new PdfPCell(new Phrase(String.format("1º Recup.", i))); //String.format faz com que o "%s" receba o "i"
                } else if (i == 6) {
                    cell = new PdfPCell(new Phrase(String.format("2º Recup.", i))); //String.format faz com que o "%s" receba o "i"
                } else if (i == 4 | i == 5) {
                    cell = new PdfPCell(new Phrase(String.format("%sº Aval", i - 1))); //String.format faz com que o "%s" receba o "i"
                } else {
                    cell = new PdfPCell(new Phrase(String.format("%sº Aval", i))); //String.format faz com que o "%s" receba o "i"
                }
                cell.setColspan(3);
                table3.addCell(cell);
                i++;
            }

//            Aqui é montado o corpo da tabela
            int j = 0;
            while (j < 4) {
                j++;
                PdfPCell cell11 = new PdfPCell(new Phrase(String.format("Disciplina " + j)));
                cell11.setColspan(4);
                table3.addCell(cell11);
                for (int g = 0; g < 6; g++) { //Aqui começa o lançamento das notas
                    int calc = 4 + (int) (Math.random() * (10 - 4));
                    cell2 = new PdfPCell(new Phrase(String.valueOf(calc)));
                    cell2.setColspan(3);
                    System.out.println(calc);
                    table3.addCell(cell2);
                }
            }

//            Aqui é montado o "rodapé"
            cell12 = new PdfPCell(new Phrase("Obs.: "));
            cell12.setRowspan(4);
            cell12.setColspan(4);
            cell12.setVerticalAlignment(Element.ALIGN_MIDDLE);
            table3.addCell(cell12);

            for (int a = 0; a < 4; a++) {
                cell12 = new PdfPCell(new Phrase("Observação " + (a + 1)));
                cell12.setColspan(18);
                table3.addCell(cell12);
            }

            doc.add(table); //Adicionando a table ao documento
            doc.add(table2);
            doc.add(table3);
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
//        int dec = JOptionPane.showConfirmDialog(null, "Deseja abrir o arquivo?");
//        if (dec == 0) {
        java.awt.Desktop.getDesktop().open(new File("Boletim.pdf"));
//        } else{
//            JOptionPane.showMessageDialog(null, "Ok!");
//        }
    }
}
