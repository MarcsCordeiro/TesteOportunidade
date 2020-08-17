package com.marcos.teste.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer marcaId;
	private String nomeMarca;
	
	public Marca() {
		
	}

	public Marca(Integer marcaId, String nomeMarca) {
		super();
		this.marcaId = marcaId;
		this.nomeMarca = nomeMarca;
	}

	public Integer getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Integer marcaId) {
		this.marcaId = marcaId;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marcaId == null) ? 0 : marcaId.hashCode());
		result = prime * result + ((nomeMarca == null) ? 0 : nomeMarca.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marca other = (Marca) obj;
		if (marcaId == null) {
			if (other.marcaId != null)
				return false;
		} else if (!marcaId.equals(other.marcaId))
			return false;
		if (nomeMarca == null) {
			if (other.nomeMarca != null)
				return false;
		} else if (!nomeMarca.equals(other.nomeMarca))
			return false;
		return true;
	}
	
	

}
