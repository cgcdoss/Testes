/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.poi;

import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author gabri
 */
public class TestaDoc {

    public static void main(String[] args) {
        DocController dc = new DocController();
        try {
            XWPFDocument doc = new XWPFDocument(OPCPackage.open("teste.docx"));
            String text;
            int qtdCampos = Integer.parseInt(JOptionPane.showInputDialog("Quantos campos?"));
            //text = JOptionPane.showInputDialog("Digite o texto");
            //String[] t = text.split(",");
            int n = 0;

//            for (String tt : t) {
//                n = n + 1;
//                String textAnt = "${campo" + n + "}";
//                doc = dc.substituiDoc(textAnt, tt, doc);
//                System.out.println(textAnt + " - " + tt);
//            }
            for (int i = 1; i <= qtdCampos; i++) {
                text = "teste" + i;
                String textAnt = "${campo" + i + "}";

                doc = dc.substituiDoc(textAnt, text, doc);
            }
            doc.write(new FileOutputStream("teste-output.docx"));

        } catch (Exception e) {

        }
    }
}
