package com.DanielZambon.crud.services;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.DanielZambon.crud.data.vo.ProdutoVO;
import com.DanielZambon.crud.entity.Produto;
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
		return page.map(this:convetToProduto);
		
	}
	
	private ProdutoVO convetToProduto(Produto produto) {
		return ProdutoVO.create(produto);
	}

	
	
	
	
	
	
	
	
	
	
}
