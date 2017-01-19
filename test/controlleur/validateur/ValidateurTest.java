/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlleur.validateur;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lalleaul
 */
public class ValidateurTest {

    @Test
    public void testDoubleValid() {
        String str = "1.4";
        assertTrue(Validateur.isDouble(str));
        String str2 = "1";
        assertTrue(Validateur.isDouble(str2));
    }

    @Test
    public void testDoubleFail() {
        String str = "1,4";
        assertFalse(Validateur.isDouble(str));
        String str2 = "a1";
        assertFalse(Validateur.isDouble(str2));
    }

}
