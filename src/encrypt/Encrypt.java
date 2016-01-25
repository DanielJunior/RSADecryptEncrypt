/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.Exponentiation;

/**
 *
 * @author danieljunior
 */
public class Encrypt {

    String inputFile;
    String outputFile;
    int e;
    char n;

    public Encrypt(String inputFile, String outputFile, char n, int e) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
        this.n = n;
        this.e = e;
    }

    public void encrypt() {
        try (FileInputStream in = new FileInputStream(inputFile)) {
            while (in.available() > 0) {
                //o read do fileinputstream lê um byte como sendo um inteiro(0-255), podemos converte-lo para um char
                //que pode ser visto como um unsigned short
                char m = (char) in.read();
                char c = Exponentiation.binaryExponentiation(m, e, n);
                System.out.println(c);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
