package ejemplos.spring.ioc.beans;

import org.springframework.stereotype.Service;

@Service(value = "servicioRemoto")
public class ServicioRemoto {

	public int consultaDato() {
		return (int) (Math.random() * 10.0);
	}
}
