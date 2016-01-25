/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Monitoria
 */
public class Exponentiation {

    public static char binaryExponentiation(char base, int e, char n) {
        long res = base;
        long y = 1;
        if (e == 0) {
            return 1;
        }
        while (e > 1) {
            //se e é impar
            if (e % 2 > 0) {
                y = (char) ((y * res) % (long) n);
                e = e - 1;
            }
            res =  (int) ((res * res) % (long) n);
            e = e / 2;
        }
        return((char) ((res * y) % n));
    }
}
