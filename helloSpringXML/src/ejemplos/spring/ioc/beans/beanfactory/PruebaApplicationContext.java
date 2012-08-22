package ejemplos.spring.ioc.beans.beanfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ejemplos.spring.ioc.beans.ServicioRemoto;

/**
 * 
 * @author A153655
 * 
 */
public class PruebaApplicationContext {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicioRemoto servicio = applicationContext.getBean("servicioRemoto", ServicioRemoto.class);
		System.out.println("El valor es " + servicio.consultaDato());
	}

}
