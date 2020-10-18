package com.zen.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.id.enhanced.TableGenerator;

import com.sun.istack.NotNull;

@Entity(name="Produto")
@Table(name="produto")
public class Produto implements Serializable{
	
    private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = TableGenerator.DEF_TABLE) 
	private long id_produto;		
	
	@NotNull
	@ManyToOne
    @JoinColumn(name="id_linha_produto")
	private Linha_produto linha_produto;
	
	@NotNull
	@Column(nullable = false)
	private long  cd_item;	
	
	@ManyToOne(optional=true, cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_veiculo", nullable = true)
	private Veiculo veiculo;
	
	@NotNull
	@Column(nullable = false, precision=5, scale=2)
	private Double peso_bruto;
	
	@NotNull
	@Column(nullable = false, precision=5, scale=2)
	private Double peso_liquido;
	
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_inclusao;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date  dt_atualizacao;
	
	@NotNull
	private long  cd_usuario;
	
	public Produto(){
		super();
	}	

	public long getId_produto() {
		return id_produto;
	}

	public void setId_produto(long id_produto) {
		this.id_produto = id_produto;
	}

	public Linha_produto getLinha_produto() {
		return linha_produto;
	}

	public void setLinha_produto(Linha_produto linha_produto) {
		this.linha_produto = linha_produto;
	}

	
	public long getCd_item() {
		return cd_item;
	}

	public void setCd_item(long cd_item) {
		this.cd_item = cd_item;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public Double getPeso_bruto() {
		return peso_bruto;
	}

	public void setPeso_bruto(Double peso_bruto) {
		this.peso_bruto = peso_bruto;
	}

	public Double getPeso_liquido() {
		return peso_liquido;
	}

	public void setPeso_liquido(Double peso_liquido) {
		this.peso_liquido = peso_liquido;
	}

	public Date getDt_inclusao() {
		return dt_inclusao;
	}

	public void setDt_inclusao(Date dt_inclusao) {
		this.dt_inclusao = dt_inclusao;
	}

	public Date getDt_atualizacao() {
		return dt_atualizacao;
	}

	public void setDt_atualizacao(Date dt_atualizacao) {
		this.dt_atualizacao = dt_atualizacao;
	}

	public long getCd_usuario() {
		return cd_usuario;
	}

	public void setCd_usuario(long cd_usuario) {
		this.cd_usuario = cd_usuario;
	}	
	
	
	
}
