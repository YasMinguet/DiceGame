package at.itacademy.barcelonactiva.cognoms.nom.s05.t02.fase2.S05T02N01BarberoYasmina.model.exception;

import java.text.MessageFormat;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code=HttpStatus.NO_CONTENT)
public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException(Long id){
		super(MessageFormat.format("No se ha podido encontrar el jugador con id; {0}", id));
	}
}