package br.com.renato.campanha.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class CadastroInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1320154346379640250L;

}
