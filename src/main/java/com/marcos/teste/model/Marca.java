package com.marcos.teste.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity
public class Marca implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer marcaId;
	
	@Column(nullable = false, unique = true)
	private String nomeMarca;
	
	@OneToMany(mappedBy = "marca")
	private List<Patrimonio> patrimonios = new ArrayList<>();
	
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
		return true;
	}

	
	
	

}
