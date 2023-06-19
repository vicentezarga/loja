package br.com.loja.negocio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.loja.negocio.model.enums.TipoMidia;

@Entity
public class Jogo extends Produto {

	@Enumerated(EnumType.STRING)
	private TipoMidia tipoMidia;
	
	private String studio;


	public Jogo() {

	}
	
	public Jogo(TipoMidia tipoMidia, String studio) {
		super();
		this.tipoMidia = tipoMidia;
		this.studio = studio;
	}

	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoMidia tipoMidia) {
		this.tipoMidia = tipoMidia;
	}

	public String getStudio() {
		return studio;
	}

	public void setStudio(String studio) {
		this.studio = studio;
	}
	
}
