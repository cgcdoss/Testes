/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideiais.arquivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author gabri
 */
public class Arquivos {

    public static void main(String[] args) {
        File diretorio
                = new File("C:/Users/gabri/Documents/NetBeansProjects/teste");
        File arquivo = null;
        File[] arquivos = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linha = "";
        File arquivoDestino
                = new File("C:/Users/gabri/Documents/NetBeansProjects/teste/textt.txt");
        FileOutputStream fos = null;
        try {
            if (diretorio.isDirectory()) {
                fos = new FileOutputStream(arquivoDestino);
                arquivos = diretorio.listFiles();
                for (File arquivo1 : arquivos) {
                    System.out.println(arquivo1);
                    arquivo = arquivo1;
                    fr = new FileReader(arquivo);
                    br = new BufferedReader(fr);
                    while ((linha = br.readLine()) != null) {
                        fos.write(linha.getBytes());
                        System.out.println("escrito!" + linha);
                    }
                    fos.write("\n".getBytes());
                }
            }
            fos.flush();
            fos.close();
        } catch (FileNotFoundException fnex) {
            fnex.printStackTrace();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
