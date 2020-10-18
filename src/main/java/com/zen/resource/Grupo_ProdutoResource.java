package com.zen.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zen.model.Grupo_produto;
import com.zen.repository.Grupo_ProdutoRepository;

@RestController
@RequestMapping(value="/zen-api")
@CrossOrigin(origins="*")
public class Grupo_ProdutoResource {
	
	@Autowired
	Grupo_ProdutoRepository grupo_ProdutoRepository;

	@GetMapping("/grupo-produto")
	public List<Grupo_produto> getLinhaProduto()  {				    
		return grupo_ProdutoRepository.findAll();	
	}	
}
