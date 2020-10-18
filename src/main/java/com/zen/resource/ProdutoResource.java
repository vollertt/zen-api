package com.zen.resource;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zen.model.Produto;
import com.zen.repository.ProdutoRepository;



@RestController
@RequestMapping(value="/zen-api")
@CrossOrigin(origins="*")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
    
	@PostMapping("/novo-produto")
	public ResponseEntity<Boolean> salvaProduto(@RequestBody Produto produto)  {	
		if(produto.getVeiculo().getId_veiculo()!=null) {
		   produtoRepository.saveProduto(produto.getLinha_produto().getId_linha_produto(),produto.getCd_item(), produto.getVeiculo().getId_veiculo(),
				                         produto.getPeso_bruto(),produto.getPeso_liquido(),new Date(),1);
		   return ResponseEntity.ok().body(true);
		}else {
			produtoRepository.saveProdutoNullVeiculo(produto.getLinha_produto().getId_linha_produto(),produto.getCd_item(),
					                                 produto.getPeso_bruto(),produto.getPeso_liquido(),new Date(),1);
			return ResponseEntity.ok().body(true);
		}
	}	
	
	@PostMapping("/remove-produto")
	public ResponseEntity<Boolean> removeProduto(@RequestBody Produto produto)  {				    
		produtoRepository.deleteById(produto.getId_produto());	
		return ResponseEntity.ok().body(true);
	}	
	
	@GetMapping("/produto-page")		
    public Page<Produto> paginaProduto(
    		 @RequestParam("page") int page, 
    		 @RequestParam("size") int size,
    		 @RequestParam("order") String order,  
             @RequestParam("direction") String direction,
             @RequestParam("id_grupo_produto") int id_grupo_produto,
             @RequestParam("id_linha_produto") int id_linha_produto) 
	{
		 Pageable pageable=null;
		 Page<Produto> resultPage=null;
		 if(order==null) {
	        order =  "ds_linha_produto";
		 }			 
		 if(direction ==null || direction.equals("DESC")){		
			 pageable = PageRequest.of(page, size, Sort.by(order).descending());
		 }else {
			 pageable = PageRequest.of(page, size, Sort.by(order));
		 }
		 if(id_grupo_produto==0 && id_linha_produto==0){
		   resultPage = produtoRepository.findPaginated( pageable);
		 }else if(id_linha_produto==0 ){
			   resultPage = produtoRepository.findPaginatedFilterGrupo(id_grupo_produto, pageable);
		 }else {
			   resultPage = produtoRepository.findPaginatedFilterLinha(id_linha_produto, pageable);
		 }
		 return resultPage;	        
    }

}
