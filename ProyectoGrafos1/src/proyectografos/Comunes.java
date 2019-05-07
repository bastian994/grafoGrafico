/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectografos;

/**
 *
 * @author Charls
 */
public class Comunes {
    static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (Exception e){
		return false;
	}
}
    
}

/*
} catch (NumberFormatException nfe){
		return false;
	}
*/