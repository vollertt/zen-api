package com.zen.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zen.model.Linha_produto;


@Repository
public  interface Linha_ProdutoRepository  extends JpaRepository<Linha_produto, Long> {

	@Query(value=" select * from linha_produto where id_grupo_produto = :id Order by ds_linha_produto",  nativeQuery = true) 
    List<Linha_produto> findByIdGrupo(@Param("id") int id); 
}
