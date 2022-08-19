package com.DanielZambon.crud.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DanielZambon.crud.data.vo.ProdutoVO;
import com.DanielZambon.crud.entity.Produto;
import com.DanielZambon.crud.exception.ResourceNotFoundException;
import com.DanielZambon.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoVO create(ProdutoVO produtoVO) {
		
		ProdutoVO proVoRetorno =  ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		return proVoRetorno;
	}
		
	public Page<ProdutoVO> findAll(Pageable pageable){
		
		var page = produtoRepository.findAll(pageable);
		return page.map(this::convetToProduto);
		
	}
	
	public ProdutoVO findById(Long id) {
		
		var entity = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return ProdutoVO.create(entity);
	}
	
	private ProdutoVO convetToProduto(Produto produto) {
		
		return ProdutoVO.create(produto);
	}
	
	public ProdutoVO update(ProdutoVO produtoVO) {
		
		final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());
		
		if(!optionalProduto.isPresent()) {
			new ResourceNotFoundException("No records found for this ID");
		}
		
		return produtoVO.create(produtoRepository.save(Produto.create(produtoVO)));
		
	}
	
	public void delete(Long id) {
		
		var entity = produtoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		produtoRepository.delete(entity);
		
	}

	
	
	
	
	
	
	
	
	
	
}
