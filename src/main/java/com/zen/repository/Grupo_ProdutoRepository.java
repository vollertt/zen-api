package com.zen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zen.model.Grupo_produto;

@Repository
public  interface Grupo_ProdutoRepository  extends JpaRepository<Grupo_produto, Long> {

}


