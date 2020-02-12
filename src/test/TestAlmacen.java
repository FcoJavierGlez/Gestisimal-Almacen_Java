package test;

import gestisimal.almacen.Almacen;
import gestisimal.almacen.ArticuloIncorrectoException;
import gestisimal.almacen.ErrorStockException;
import gestisimal.almacen.IVA;
import gestisimal.almacen.IvaInvalidoException;
import gestisimal.utiles.*;

/**
 * 
 * TestAlmacen es una clase de prueba del programa Gestisimal (GESTIón SIMplificada de Almacén),
 * entre sus funciones encontramos:
 * 
 * <ul>
 * <li>Listado de artículos</li>
 * <li>Dar de alta un artículo</li>
 * <li>Dar de baja un artículo</li>
 * <li>Modificar artículo</li>
 * <li>Entrada de mercancia</li>
 * <li>Salida de mercancia</li>
 * </ul>
 * 
 * Se debe controlar que no se pueda sacar más mercancía de la que hay en el almacén y que, cada
 * artículo posea su propio identificador generado automáticamente.
 * 
 * 
 * @author Francisco Javier González Sabariego
 *
 */
public class TestAlmacen {
  //Menus:
  static Menu m = new Menu("Menu principal", new String[] { "Listado de artículos", "Dar de alta un artículo", 
      "Dar de baja un artículo", "Modificar artículo", "Entrada de mercancia", "Salida de mercancia", "Salir" });
  static Menu menuIva = new Menu("Tipo de IVA", new String[] { "General", "Reducido", "Super reducido" });
  static Menu menuMod = new Menu("Modificar", new String[] { "Descripción", "Precio de compra", "Precio de venta", "Tipo de IVA" });
  
  //Almacén:
  private static Almacen almacen = new Almacen();
  
  public static void main(String[] args) {
    while (true) {
      switch (m.interactua()) {
      case 1:
        System.out.println(almacen.mostrarLista());
        break;
      case 2:
        altaArticulo();
        break;
      case 3:
        bajaArticulo();
        break;
      case 4:
        modificaArticulo();
        break;
      case 5:
        entradaMercancia();
        break;
      case 6:
        salidaMercancia();
        break;
      case 7:
        System.out.print("Gracias por usar Gestisimal.");
        return;//System.exit(0);
      }
    }

  }

  // MÉTODOS \\

  /**
   * Imprime el menú con los tipos de IVA que puede tener un artículo
   * y devuelve el valor elegido en forma de tipo enumerado.
   * 
   * @return Tipo de IVA (Enumerado)
   */
  private static IVA menuIva() {
    switch (menuIva.interactua()) {
      case 1:
        return IVA.GENERAL;
      case 2:
        return IVA.REDUCIDO;
      default:
        return IVA.SUPER_REDUCIDO;
//      default:
//        return null;
    }
  }
  
  
  /**
   * Permite ingresar un nuevo artículo a la lista. Se requiere almacenar:
   * 
   * <ul>
   * <li>La descripción del artículo</li>
   * <li>El precio de compra</li>
   * <li>El precio de venta</li>
   * </ul>
   * 
   */
  private static void altaArticulo() {    
    try {
      almacen.alta(Teclado.leeCadena("\nAsigna la descripción del artículo."), 
          Teclado.leeDecimal("\nAsigna el precio de compra del artículo."),
          Teclado.leeDecimal("\nAsigna el precio de venta del artículo."),
          menuIva());
    } catch (IvaInvalidoException e) {
      System.err.println("El artículo no pudo ser creado."+e.getMessage());
    }

  }
  

  /**
   * Elimina un artículo de la lista de artículos. Para ello comprueba:
   * <ul>
   * <li>Que el número de existencias de ese artículo no sea superior a 0.</li>
   * </ul>
   * 
   * @param art Lista de artículos
   * @param s   Scanner
   */
  private static void bajaArticulo() {
    try {
      almacen.baja(Teclado.leeEntero("\nInserte el código de artículo."));
    } catch (ArticuloIncorrectoException aie) {}
  }

  /**
   * Modifica los atributos de un artículo seleccionado, los atributos
   * modificables son:
   * <ul>
   * <li>Descripción</li>
   * <li>Precio de compra</li>
   * <li>Precio de venta</li>
   * </ul>
   * 
   */
  private static void modificaArticulo() {    
    switch (menuMod.interactua()) {
    case 1:
      modificarDescripcion();
      break;
    case 2:
      modificarPrecioCompra();
      break;
    case 3:
      modificarPrecioVenta();
      break;
    default:
      modificarIva();
      break;
    }
    
  }
  
  
  /**
   * Modifica la descripción del artículo.
   */
  private static void modificarDescripcion() {
    try {
      almacen.modificarDescripcion(Teclado.leeEntero("Dime el código del artículo"), Teclado.leeCadena("Introduce la nueva descripción"));
    } catch (ArticuloIncorrectoException aie) {
      System.err.println("El artículo seleccionado no existe.");
    }
  }
  
  
  /**
   * Modifica el precio de compra del artículo.
   */
  private static void modificarPrecioCompra() {
    try {
      almacen.modificarPrecioCompra(Teclado.leeEntero("\nDime el código del artículo"), Teclado.leeDecimal("\nDime el nuevo precio de compra"));
    } catch (ArticuloIncorrectoException aie) {
      System.err.println("El artículo seleccionado no existe.");
    }
  }
  
  
  /**
   * Modifica el precio de venta del artículo.
   */
  private static void modificarPrecioVenta() {
    try {
      almacen.modificarPrecioVenta(Teclado.leeEntero("\nDime el código del artículo"), Teclado.leeDecimal("\nDime el nuevo precio de venta"));
    } catch (ArticuloIncorrectoException e) {
      System.err.println("El artículo seleccionado no existe.");
    }
  }
  
  
  /**
   * Modifica el tipo de IVA del artículo.
   */
  private static void modificarIva() {
    try {
      almacen.modificarIva(Teclado.leeEntero("\nDime el código del artículo"), menuIva());
    } catch (ArticuloIncorrectoException e) {
      System.err.println("El artículo seleccionado no existe.");
    } catch (IvaInvalidoException e) {
      System.err.println("Tipo de IVA incorrecto.");
    }
  }
  

  /**
   * Método que se encarga de gestionar la entrada de artículos del almacén,
   * certifando que no puedan ingresar un número negativo de artículos.
   * 
   */
  private static void entradaMercancia() {
    try {
      almacen.entradaMercancia(Teclado.leeEntero("\nInserte el código del artículo del que ha entrado mercancia"),
          Teclado.leeEntero("\n¿Cuántos artículos han entrado?"));
    } catch (ArticuloIncorrectoException | ErrorStockException aie) {
      System.err.println("Artículo incorrecto.");
    }
  }

  /**
   * Método que se encarga de gestionar la entrada de artículos del almacén,
   * certifando que no puedan ingresar un número negativo de artículos.
   * 
   * @param Teclado Teclado
   */
  private static void salidaMercancia() {
    try {
      almacen.salidaMercancia(Teclado.leeEntero("\nInserte el código del artículo del que ha entrado mercancia"),
          Teclado.leeEntero("\n¿Cuántos artículos han salido?"));
    } catch (ArticuloIncorrectoException aie) {
      System.err.println("El artículo seleccionado no existe.");
    } catch (ErrorStockException e) {
      System.err.println("Stock incorrecto. No se puede extraer más artículos de los almacenados.");
    }
  }
}
