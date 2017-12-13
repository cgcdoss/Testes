
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncriptaDecriptaDES {

    public static void main(String[] argv) {

        try {

//            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
//            SecretKey chaveDES = keygenerator.generateKey();
            String chave = "A1B2C3D4";
            byte[] desKeyData = (chave).getBytes();
            SecretKeySpec chaveDES = new SecretKeySpec(desKeyData, "DES");

            System.out.println("Chave: " + chave);
            Cipher cifraDES;

            // Cria a cifra 
            cifraDES = Cipher.getInstance("DES/ECB/PKCS5Padding");

            // Inicializa a cifra para o processo de encriptação
            cifraDES.init(Cipher.ENCRYPT_MODE, chaveDES);

            // Texto puro
            String texto = "Teste";
            byte[] textoPuro = texto.getBytes("UTF-8");

            System.out.println("Texto [Formato de Byte] : " + textoPuro);
            System.out.println("Texto Puro : " + texto);

            // Texto encriptado
            byte[] textoEncriptado = cifraDES.doFinal(textoPuro);
            String textoCrip = new String(textoEncriptado, "UTF-8");

            System.out.println("Texto Encriptado : " + textoCrip);

            // Inicializa a cifra também para o processo de decriptação
            
            cifraDES.init(Cipher.DECRYPT_MODE, chaveDES);

            // Decriptografa o texto
            byte[] textoDecriptografado = cifraDES.doFinal(textoEncriptado);

            System.out.println("Texto Decriptografado : " + new String(textoDecriptografado));

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(EncriptaDecriptaDES.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
