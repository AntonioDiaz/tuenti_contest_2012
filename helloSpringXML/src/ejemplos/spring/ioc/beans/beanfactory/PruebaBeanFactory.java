package ejemplos.spring.ioc.beans.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import ejemplos.spring.ioc.beans.ServicioRemoto;

public class PruebaBeanFactory {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		ServicioRemoto servicio = beanFactory.getBean("servicioRemoto", ServicioRemoto.class);
		System.out.println("El valor es " + servicio.consultaDato());
	}
}
