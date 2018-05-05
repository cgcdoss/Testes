/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.poi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

/**
 *
 * @author gabri
 */
public class GravaDoc {

    public static String logo = "logo-leaf.png";
    public static String paragraph1 = "poi-word-para1.txt";
    public static String paragraph2 = "poi-word-para2.txt";
    public static String paragraph3 = "poi-word-para3.txt";
    public static String output = "rest-with-spring.docx";

    public static void main(String[] args) {
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

    public String convertTextFileToString(String fileName) {
        try (Stream<String> stream
                = Files.lines(Paths.get(ClassLoader.getSystemResource(fileName).toURI()))) {

            return stream.collect(Collectors.joining(" "));
        } catch (IOException | URISyntaxException e) {
            return null;
        }
    }
}
