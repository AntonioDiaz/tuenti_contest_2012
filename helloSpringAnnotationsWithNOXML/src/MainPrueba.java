import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ejemplos.spring.ioc.beans.ServicioRemoto;

/**
 * 
 * @author A153655
 *
 */
public class MainPrueba {

	public static void main(String[] args) {
		
		//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ServicioRemoto.class);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ejemplos.spring.ioc.beans");
		ServicioRemoto servicio = applicationContext.getBean("servicioRemoto", ServicioRemoto.class);
		System.out.println("El valor es " + servicio.consultaDato());
	}
}
