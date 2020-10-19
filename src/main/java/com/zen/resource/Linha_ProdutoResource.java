package com.zen.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zen.model.Linha_produto;
import com.zen.repository.Linha_ProdutoRepository;


@RestController
@RequestMapping(value="/zen-api")
@CrossOrigin(origins="*")
public class Linha_ProdutoResource {
	
	@Autowired
	Linha_ProdutoRepository linha_ProdutoRepository;

	@GetMapping("/linha-produto")
	public List<Linha_produto> getLinhaProduto(@RequestParam int id_grupo_produto)  {				    
		return linha_ProdutoRepository.findByIdGrupo(id_grupo_produto);	
	}	
	
}
