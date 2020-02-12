package gestisimal.utiles;

import gestisimal.utiles.Teclado;

/**
 * Clase Menu, imprime un menú en pantalla y solicita la opción a elegir.
 * 
 * @author Francisco Javier González Sabariego
 *
 */
public class Menu {
  private String nombreMenu;
  private String [] opciones;
  
  /**
   * Constructor de la Clase Menú.
   * 
   * @param nombreMenu  Nombre que asignamos al menú.
   * @param opciones    Las opciones que deberá mostrar.
   */
  public Menu(String nombreMenu, String[] opciones) {
    this.nombreMenu = nombreMenu;
    this.opciones = opciones;
  }
  
  /**
   * Imprime el menú en pantalla, pide una opción y retorna el valor elegido.
   * 
   * @return Número (int) correspondiente a la opción elegida.
   */
  public int interactua() {    
    imprimeMenu();        
    return opcionElegida();
  }

  /**
   * Retorna el valor de la opción elegida.
   * 
   * @return Número (int) de la opción elegida.
   */
  private int opcionElegida() {
    return Teclado.leeEntero("\nElige una opción");
  }
  
  /**
   * Imprime el menú por pantalla.
   */
  private void imprimeMenu() {
    imprimeNombreMenu();
    for (int i=0; i<this.opciones.length; i++) {
      System.out.println("(" + (i+1) + ")" + opciones[i]);
    }
  }

  /**
   * Imprime el nombre del menú.
   */
  private void imprimeNombreMenu() {
    String subrayado = "";
    System.out.println(this.nombreMenu);
    for (int i=0; i<this.nombreMenu.length(); i++) {
      subrayado+="=";
    }
    System.out.println(subrayado);
  }
}
