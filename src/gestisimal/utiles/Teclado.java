package gestisimal.utiles;

import java.util.Scanner;

/**
 * Clase teclado, lee la entrada de datos y retorna el valor si es correcto.
 * 
 * @author Francisco Javier González Sabariego
 *
 */
public class Teclado {
  
  static Scanner s = new Scanner(System.in);
  
  /**
   * Lee y devuelve una cadena.
   * 
   * @return Cadena de caracteres (String).
   */
  public static String leeCadena() {
    return s.nextLine();
  }
  
  /**
   * Imprime un mensaje por pantalla, lee y devuelve una cadena.
   * 
   * @return Cadena de caracteres (String).
   */
  public static String leeCadena(String mensaje) {
    System.out.println(mensaje);
    return leeCadena();
  }
  
  /**
   * Lee y devuelve un caracter.
   * 
   * @return Caracter (char).
   */
  public static char leeCaracter() {
    try {
      return leeCadena().charAt(0);
    } catch (Exception e) {
      System.err.println("Caracter incorrecto.");
      return 0;
    }
  }
  
  /**
   * Imprime un mensaje por pantalla, lee y devuelve un caracter.
   * 
   * @return Caracter (char).
   */
  public static char leeCaracter(String mensaje) { 
    try {
      return leeCadena(mensaje).charAt(0);
    } catch (Exception e) {
      System.err.println("Caracter incorrecto.");
      return 0;
    }
  }
  
  /**
   * Lee y devuelve un entero.
   * 
   * @return Número entero (int).
   */
  public static int leeEntero() {
    try {
      return Integer.parseInt(leeCadena());
    } catch (Exception e) {
      System.err.println("No ha insertado un número entero. Por defecto valdrá 0.");
      return 0;
    }    
  }
  
  /**
   * Imprime un mensaje por pantalla, lee y devuelve un entero.
   * 
   * @return Número entero (int).
   */
  public static int leeEntero(String mensaje) {
    try {
      return Integer.parseInt(leeCadena(mensaje));
    } catch (Exception e) {
      System.err.println("No ha insertado un número entero. Por defecto valdrá 0.");
      return 0;
    }
  }
  
  /**
   * Lee y devuelve un decimal.
   * 
   * @return Número decimal (double).
   */
  public static double leeDecimal() {
    try {
      return Double.parseDouble(leeCadena());
    } catch (Exception e) {
      System.err.println("No ha insertado un número decimal. Por defecto valdrá 0.");
      return 0;
    }
  }
  
  /**
   * Imprime un mensaje por pantalla, lee y devuelve un decimal.
   * 
   * @return Número decimal (double).
   */
  public static double leeDecimal(String mensaje) {
    try {
      return Double.parseDouble(leeCadena(mensaje));
    } catch (Exception e) {
      System.err.println("No ha insertado un número decimal. Por defecto valdrá 0.");
      return 0;
    }
  }  
  
}
