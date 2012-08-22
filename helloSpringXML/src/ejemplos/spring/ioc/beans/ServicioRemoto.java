package ejemplos.spring.ioc.beans;

/**
 * 
 * @author A153655
 *
 */
public class ServicioRemoto {

	/**
	 * 
	 * @return
	 */
	public int consultaDato() {
		return (int) (Math.random() * 10.0);
	}
}
