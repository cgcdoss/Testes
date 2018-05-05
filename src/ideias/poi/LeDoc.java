/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author gabri
 */
public class LeDoc {

    public static void main(String[] args) {
        DocController dc = new DocController();
        dc.leDoc("rest-with-spring.docx");
    }
}
