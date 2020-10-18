package com.zen.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zen.model.Veiculo;
import com.zen.repository.VeiculoRepository;

@RestController
@RequestMapping(value="/zen-api")
@CrossOrigin(origins="*")
public class VeiculoResource {
	
	@Autowired
	VeiculoRepository veiculoRepository;

	@GetMapping("/veiculo")
	public List<Veiculo> getVeiculo(@RequestParam("id_linha_produto") int id_linha_produto)  {		
		return veiculoRepository.findVeiculoNotIncludeOrderByMarca(id_linha_produto);	
	}	
}
