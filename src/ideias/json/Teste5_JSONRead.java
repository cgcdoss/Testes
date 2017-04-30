/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Cássio Gabriel
 */
public class Teste5_JSONRead {

    public static void main(String[] args) {
        lerJson("saida.json");
    }

    public static void lerJson(String nomeArquivo) {
        JSONObject jsonObject;
        //Cria o parse de tratamento
        JSONParser parser = new JSONParser();
        //Variaveis que irao armazenar os dados do arquivo JSON
        String driver;
        String caminho;
        String usuario;
        String senha;
        FileReader arquivo;

        try {
            arquivo = new FileReader(nomeArquivo);
            //Salva no objeto JSONObject o que o parse tratou do arquivo
            jsonObject = (JSONObject) parser.parse(arquivo);

            //Salva nas variaveis os dados retirados do arquivo
            driver = (String) jsonObject.get("driver");
            caminho = (String) jsonObject.get("caminho");
            usuario = (String) jsonObject.get("usuario");
            senha = (String) jsonObject.get("senha");

            System.out.printf(
                    "Driver: %s\nCaminho: %s\nUsuário: %s\nSenha: %s\n",
                    driver, caminho, usuario, senha);
        } //Trata as exceptions que podem ser lançadas no decorrer do processo
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
