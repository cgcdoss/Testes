/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideias.criptografia.simetrica;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class CripBase64 {

    public static void main(String[] args) {
        try {
            String texto = "{\n"
                    + "	\"driver\":\"com.mysql.jdbc.Driver\",\n"
                    + "	\"banco\":\"projeto-nis2\",\n"
                    + "	\"caminho\":\"jdbc:mysql://localhost/\",\n"
                    + "	\"usuario\":\"root\",\n"
                    + "	\"senha\":\"a1b2c3d4\"\n"
                    + "}";
            byte[] textoPuro = texto.getBytes();

            String crip = Base64.encode(textoPuro);
            System.out.println(crip + "\n");

            String decrip = new String(Base64.decode(crip.getBytes()));
            System.out.println(decrip);
        } catch (Base64DecodingException ex) {
            Logger.getLogger(MessageDigestTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
