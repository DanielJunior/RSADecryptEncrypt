/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package encrypt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
        try (FileInputStream in = new FileInputStream(inputFile); Writer out = new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8")) {
            System.out.println("\n*******************************\nMensagem criptografada:");
            while (in.available() > 0) {
                //o read do fileinputstream lê um byte como sendo um inteiro(0-255), podemos converte-lo para um char
                //que pode ser visto como um unsigned short(16bits)
                char m = (char) in.read();
                char c = Exponentiation.binaryExponentiation(m, e, n);
                System.out.print(c);
                out.write(c);
            }
            System.out.println("\n*******************************\n");
        } catch (FileNotFoundException ex) {
            System.err.println("Arquivo não encontrado!");    
        } catch (IOException ex) {
            System.err.println("Houve um erro na manipulação do arquivo");;
        }
    }
}
