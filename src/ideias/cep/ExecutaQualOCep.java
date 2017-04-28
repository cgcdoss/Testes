package ideias.cep;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ExecutaQualOCep {
    
    public static void main(String[] args) {
        QualOCep qop = new QualOCep();
        String cep = JOptionPane.showInputDialog(null, "Infome o cep");
        try {
            qop.getCidade(cep);
            System.out.println("Endereço: " + qop.getEndereco(cep));
            System.out.println("Bairro: " + qop.getBairro(cep));
            System.out.println("Cidade: " + qop.getCidade(cep));
            System.out.println("UF: " + qop.getUF(cep));
            JOptionPane.showMessageDialog(null, "Enderço: " + qop.getEndereco(cep) + "\nBairro: " + 
                    qop.getBairro(cep) + "\nCidade: " + qop.getCidade(cep) + "\nUF: " + qop.getUF(cep));
        } catch (IOException ex) {
            Logger.getLogger(ExecutaQualOCep.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
