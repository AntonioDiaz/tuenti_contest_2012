import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ejemplos.spring.ioc.beans.ServicioRemoto;

public class PruebaMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		ServicioRemoto servicioRemoto = applicationContext.getBean("servicioRemoto", ServicioRemoto.class);
		System.out.println("El valor es: " + servicioRemoto.consultaDato());
	}
}
