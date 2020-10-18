package com.zen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zen.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	@Query(value=" SELECT * from veiculo , marca_veiculo where veiculo.id_marca=marca_veiculo.id_marca and veiculo.id_veiculo not in(select id_veiculo from produto where id_veiculo is not null and id_linha_produto= :id_linha_produto ) order by marca_veiculo.ds_marca, veiculo.ds_veiculo",    		
    		nativeQuery = true) 
    List<Veiculo> findVeiculoNotIncludeOrderByMarca(@Param("id_linha_produto") int id_linha_produto); 
}
