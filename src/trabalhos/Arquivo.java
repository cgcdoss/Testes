/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class Arquivo {

    public static void main(String[] args) {
        File file = new File("D:");
        List<String> pastas = new ArrayList();
        List<String> arquivos = new ArrayList();
        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                pastas.add(f.getPath());
            } else if (f.isFile()) {
                arquivos.add(f.getPath());
            }
        }

        System.out.println("Pastas:");
        pastas.forEach((pasta) -> {
            System.out.println(pasta);
        });

        System.out.println("--------------------\nArquivos:");
        arquivos.forEach((arquivo) -> {
            System.out.println(arquivo);
        });
    }
}
