package com.zen.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.id.enhanced.TableGenerator;
import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

@Entity
@Table(name="veiculo")
public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE, generator = TableGenerator.DEF_TABLE) 
	private Integer id_veiculo;
	
	@NotNull
	@Column(nullable = false)
	@Length(max = 200)  
	@Size(min = 1, max = 200)
	private String ds_veiculo;

	
	@ManyToOne(optional=true,cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_marca", nullable = true)
	private Marca_veiculo marca_veiculo;	
	
	public Veiculo(){
		super();
	}	

	public Integer getId_veiculo() {
		return id_veiculo;
	}

	public void setId_veiculo(Integer id_veiculo) {
		this.id_veiculo = id_veiculo;
	}

	public String getDs_veiculo() {
		return ds_veiculo;
	}
	public void setDs_veiculo(String ds_veiculo) {
		this.ds_veiculo = ds_veiculo;
	}
	
	public Marca_veiculo getMarca_veiculo() {
		return marca_veiculo;
	}
	public void setMarca_veiculo(Marca_veiculo marca_veiculo) {
		this.marca_veiculo = marca_veiculo;
	}
	
	
}
