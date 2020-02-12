package gestisimal.almacen;

import java.util.ArrayList;

/**
* Clase Almacen que se encarga de la gestión de todo el almacen y de la comunicación con la clase Articulo.
* 
* @author JavierGF00 R4f4Lc FcoJavierGlez
*
*/
public class Almacen {
  
  private ArrayList<Articulo> almacen = new ArrayList<Articulo>();
   
   
  /**
   * Devuelve un articulo si existe
   * 
   * @param codigo  Código del artículo (int) a buscar.
   * @return  Devuelve el artículo
   * @throws ArticuloIncorrectoException Lanza esta excepción cuando el código del artículo no es válido.
   */
  private Articulo getArticulo(int codigo) throws ArticuloIncorrectoException {
    try {
      return almacen.get((almacen.indexOf(new Articulo(codigo))));
    } catch (IndexOutOfBoundsException e) {
      throw new ArticuloIncorrectoException("El código artículo es inválido.");
    }
  }
  
  /**
   * Añade el artículo al almacén siempre y cuando no exista.
   * 
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @return true de que ha insertado correctamente
   * @throws IvaInvalidoException Lanza esta excepción si el artículo recibe un tipo de IVA null
   */
    public boolean alta(String descripcion, double precioCompra, double precioVenta, IVA iva) throws IvaInvalidoException {
      return almacen.add(new Articulo(descripcion, precioCompra, precioVenta, iva));      
    }
  
  /**
   * Elimina el artículo del almacén siempre y cuando exista.
   * @param codigo
   * @return true si se ha eliminado. false en otro caso
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo seleccionado no existe.
   */
  public boolean baja(int codigo) throws ArticuloIncorrectoException  {
    return almacen.remove(getArticulo(codigo)); 
  }
   
  /**
   * Modifica la descripción del artículo del almacén siempre y cuando exista.
   * 
   * @param codigo código del articulo
   * @param descripcion descripción nueva del articulo
   * @return true si se ha modificado. false en otro caso
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo no existe.
   */
  public void modificarDescripcion(int codigo, String descripcion) throws ArticuloIncorrectoException {
    getArticulo(codigo).setDescripcion(descripcion);
  }
  
  /**
   * Modifica el precio de compra del artículo del almacén siempre y cuando exista.
   * 
   * @param codigo código del articulo
   * @param PrecioCompra Precio de compra nuevo del articulo
   * @return true si se ha modificado. false en otro caso
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo no existe.
   */
  public void modificarPrecioCompra(int codigo, double PrecioCompra) throws ArticuloIncorrectoException {
    getArticulo(codigo).setPrecioCompra(PrecioCompra);
  }
  
  /**
   * Modifica el precio de venta del artículo del almacén siempre y cuando exista.
   * 
   * @param codigo código del articulo
   * @param PrecioVenta Precio de venta nuevo del articulo
   * @return true si se ha modificado. false en otro caso
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo no existe.
   */
  public void modificarPrecioVenta(int codigo, double PrecioVenta) throws ArticuloIncorrectoException {
    getArticulo(codigo).setPrecioVenta(PrecioVenta);
  }
  
  
  /**
   * Modifica el precio de venta del artículo del almacén siempre y cuando exista.
   * 
   * @param codigo código del articulo
   * @param PrecioVenta Precio de venta nuevo del articulo
   * @return true si se ha modificado. false en otro caso
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo no existe.
   * @throws IvaInvalidoException Lanza esta excepción si el artículo recibe un tipo de IVA null.
   */
  public void modificarIva(int codigo, IVA iva) throws IvaInvalidoException, ArticuloIncorrectoException {
    getArticulo(codigo).setTipoDeIva(iva);
  }
  
  
  /**
   * Añade a cada articulo más stock.
   * 
   * @param codigo Código del articulo
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo no existe.
   * @throws ErrorStockException Lanza esta excepción cuando el stock es negativo.
   */
  public void entradaMercancia(int codigo, int cantidadArticulos) throws ErrorStockException, ArticuloIncorrectoException {
    getArticulo(codigo).incrementaStock(cantidadArticulos);
  }
  
  
  /**
   * Elimina stock a cada articulo.
   * 
   * @param codigo Código del articulo
   * @throws ArticuloIncorrectoException Lanza esta excepción si el artículo no existe.
   * @throws ErrorStockException Lanza esta excepción cuando el stock es negativo.
   */
  public void salidaMercancia(int codigo, int cantidadArticulos) throws ErrorStockException, ArticuloIncorrectoException {
    getArticulo(codigo).decrementaStock(cantidadArticulos);
  }
  
  
  /**
   * Muestra todos los articulos en el almacen.
   * 
   * @return 
   */
  public StringBuilder mostrarLista() {
    StringBuilder cadena = new StringBuilder();
    for (int i=0; i<almacen.size(); i++) {
      cadena.append("\n\nArtículo nº (" + (almacen.get(i)).getCodigo() + "): \n" + (almacen.get(i)).toString());
    }
    return cadena;
  }
  
}
