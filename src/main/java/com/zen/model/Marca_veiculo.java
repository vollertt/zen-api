package com.zen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="marca_veiculo")
public class Marca_veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy= GenerationType.TABLE, generator = TableGenerator.DEF_TABLE) 
	private long id_marca;	

	@Column(nullable = false)
	@Length(max = 200)  
	@Size(min = 1, max = 200)
	private String ds_marca;
	
	public Marca_veiculo(){
		super();
	}	
	
	public long getId_marca() {
		return id_marca;
	}
	public void setId_marca(long id_marca) {
		this.id_marca = id_marca;
	}
	public String getDs_marca() {
		return ds_marca;
	}
	public void setDs_marca(String ds_marca) {
		this.ds_marca = ds_marca;
	}	
	

}
