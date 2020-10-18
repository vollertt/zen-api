package com.zen.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
@Table(name="linha_produto")
public class Linha_produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_linha_produto;	
	
	@NotNull
	@Column(nullable = false)
	@Length(max = 200)  
	@Size(min = 1, max = 200)
	private String ds_linha_produto;
	
	@NotNull
	@ManyToOne
    @JoinColumn(name="id_grupo_produto")
	private Grupo_produto grupo_produto;
	
	public Linha_produto(){
		super();
	}	

	public long getId_linha_produto() {
		return id_linha_produto;
	}
	public void setId_linha_produto(long id_linha_produto) {
		this.id_linha_produto = id_linha_produto;
	}

	public String getDs_linha_produto() {
		return ds_linha_produto;
	}
	public void setDs_linha_produto(String ds_linha_produto) {
		this.ds_linha_produto = ds_linha_produto;
	}

	public Grupo_produto getGrupo_produto() {
		return grupo_produto;
	}
	public void setGrupo_produto(Grupo_produto grupo_produto) {
		this.grupo_produto = grupo_produto;
	}
		

}
