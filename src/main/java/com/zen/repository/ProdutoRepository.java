package com.zen.repository;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zen.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value=" select * from (SELECT produto.id_produto,produto.id_linha_produto, produto.cd_item,produto.dt_inclusao, produto.dt_atualizacao, produto.peso_bruto,produto.peso_liquido, produto.cd_usuario,linha_produto.ds_linha_produto,grupo_produto.id_grupo_produto,grupo_produto.ds_grupo_produto, veiculo.id_veiculo, veiculo.ds_veiculo, marca_veiculo.id_marca, marca_veiculo.ds_marca  FROM produto as produto LEFT JOIN linha_produto ON produto.id_linha_produto=linha_produto.id_linha_produto LEFT JOIN grupo_produto  ON linha_produto.id_grupo_produto=grupo_produto.id_grupo_produto LEFT JOIN veiculo  ON produto.id_veiculo=veiculo.id_veiculo LEFT JOIN marca_veiculo  ON marca_veiculo.id_marca=veiculo.id_marca ) as produto  ",
    		countQuery = " SELECT count(*) FROM produto as produto LEFT JOIN linha_produto ON produto.id_linha_produto=linha_produto.id_linha_produto LEFT JOIN grupo_produto  ON linha_produto.id_grupo_produto=grupo_produto.id_grupo_produto LEFT JOIN veiculo  ON produto.id_veiculo=veiculo.id_veiculo LEFT JOIN marca_veiculo  ON marca_veiculo.id_marca=veiculo.id_marca ",
    		nativeQuery = true) 
    Page<Produto> findPaginated(Pageable pageable); 

	@Query(value=" select * from (SELECT produto.id_produto,produto.id_linha_produto, produto.cd_item,produto.dt_inclusao, produto.dt_atualizacao, produto.peso_bruto,produto.peso_liquido, produto.cd_usuario,linha_produto.ds_linha_produto,grupo_produto.id_grupo_produto,grupo_produto.ds_grupo_produto, veiculo.id_veiculo, veiculo.ds_veiculo, marca_veiculo.id_marca, marca_veiculo.ds_marca  FROM produto as produto LEFT JOIN linha_produto ON produto.id_linha_produto=linha_produto.id_linha_produto LEFT JOIN grupo_produto  ON linha_produto.id_grupo_produto=grupo_produto.id_grupo_produto LEFT JOIN veiculo  ON produto.id_veiculo=veiculo.id_veiculo LEFT JOIN marca_veiculo  ON marca_veiculo.id_marca=veiculo.id_marca ) as produto WHERE produto.id_grupo_produto = :id_grupo_produto ",
    		countQuery = " SELECT count(*) FROM produto as produto LEFT JOIN linha_produto ON produto.id_linha_produto=linha_produto.id_linha_produto LEFT JOIN grupo_produto  ON linha_produto.id_grupo_produto=grupo_produto.id_grupo_produto LEFT JOIN veiculo  ON produto.id_veiculo=veiculo.id_veiculo LEFT JOIN marca_veiculo  ON marca_veiculo.id_marca=veiculo.id_marca WHERE grupo_produto.id_grupo_produto = :id_grupo_produto",
    		nativeQuery = true) 
    Page<Produto> findPaginatedFilterGrupo(@Param("id_grupo_produto") int id_grupo_produto,  Pageable pageable); 

	@Query(value=" select * from (SELECT produto.id_produto,produto.id_linha_produto, produto.cd_item,produto.dt_inclusao, produto.dt_atualizacao, produto.peso_bruto,produto.peso_liquido, produto.cd_usuario,linha_produto.ds_linha_produto,grupo_produto.id_grupo_produto,grupo_produto.ds_grupo_produto, veiculo.id_veiculo, veiculo.ds_veiculo, marca_veiculo.id_marca, marca_veiculo.ds_marca  FROM produto as produto LEFT JOIN linha_produto ON produto.id_linha_produto=linha_produto.id_linha_produto LEFT JOIN grupo_produto  ON linha_produto.id_grupo_produto=grupo_produto.id_grupo_produto LEFT JOIN veiculo  ON produto.id_veiculo=veiculo.id_veiculo LEFT JOIN marca_veiculo  ON marca_veiculo.id_marca=veiculo.id_marca ) as produto WHERE produto.id_linha_produto = :id_linha_produto ",
    		countQuery = " SELECT count(*) FROM produto as produto LEFT JOIN linha_produto ON produto.id_linha_produto=linha_produto.id_linha_produto LEFT JOIN grupo_produto  ON linha_produto.id_grupo_produto=grupo_produto.id_grupo_produto LEFT JOIN veiculo  ON produto.id_veiculo=veiculo.id_veiculo LEFT JOIN marca_veiculo  ON marca_veiculo.id_marca=veiculo.id_marca WHERE linha_produto.id_linha_produto = :id_linha_produto",
    		nativeQuery = true) 
    Page<Produto> findPaginatedFilterLinha( @Param("id_linha_produto") int id_linha_produto,  Pageable pageable); 
	
	@Query(value="INSERT INTO public.produto(id_linha_produto, cd_item, id_veiculo, peso_bruto, peso_liquido, dt_inclusao,  cd_usuario) VALUES (:id_linha_produto, :cd_item, :id_veiculo, :peso_bruto, :peso_liquido, :dt_inclusao, :cd_usuario) returning id_produto", nativeQuery = true)
    long saveProduto(
		@Param("id_linha_produto") long id_linha_produto, @Param("cd_item") long cd_item,
		@Param("id_veiculo") Integer id_veiculo, @Param("peso_bruto") Double peso_bruto,
		@Param("peso_liquido") Double peso_liquido, @Param("dt_inclusao") Date dt_inclusao,
		@Param("cd_usuario") int cd_usuario
	);
	
	@Query(value="INSERT INTO public.produto(id_linha_produto, cd_item, peso_bruto, peso_liquido, dt_inclusao,  cd_usuario) VALUES (:id_linha_produto, :cd_item,  :peso_bruto, :peso_liquido, :dt_inclusao,  :cd_usuario) returning id_produto", nativeQuery = true)
    long saveProdutoNullVeiculo(
		@Param("id_linha_produto") long id_linha_produto, @Param("cd_item") long cd_item,
		@Param("peso_bruto") Double peso_bruto,@Param("peso_liquido") Double peso_liquido, 
		@Param("dt_inclusao") Date dt_inclusao,	@Param("cd_usuario") int cd_usuario
	);
}

