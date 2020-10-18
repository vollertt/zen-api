package com.zen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
@Table(name="grupo_produto")
public class Grupo_produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private long id_grupo_produto;
	
	@NotNull
	@Column(nullable = false)
	@Length(max = 200)  
	@Size(min = 1, max = 200)
	private String ds_grupo_produto;
	
	public Grupo_produto(){
		super();
	}	

	public long getId_grupo_produto() {
		return id_grupo_produto;
	}

	public void setId_grupo_produto(long id_grupo_produto) {
		this.id_grupo_produto = id_grupo_produto;
	}

	public String getDs_grupo_produto() {
		return ds_grupo_produto;
	}

	public void setDs_grupo_produto(String ds_grupo_produto) {
		this.ds_grupo_produto = ds_grupo_produto;
	}	
	
	
}
