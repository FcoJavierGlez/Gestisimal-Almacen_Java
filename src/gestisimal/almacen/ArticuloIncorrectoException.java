package gestisimal.almacen;

/**
 * Clase ArticuloIncorrectoException (hereda de Exception), esta clase se emplea
 * para lanzar la excepción ArticuloIncorrectoException cuando el artículo no exista.
 * 
 * @author Francisco Javier González Sabariego
 *
 */
public class ArticuloIncorrectoException extends Exception {
  public ArticuloIncorrectoException(String mensaje) {
    System.err.println(mensaje);
  }
}
