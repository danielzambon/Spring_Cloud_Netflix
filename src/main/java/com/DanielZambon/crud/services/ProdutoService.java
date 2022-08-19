package com.DanielZambon.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DanielZambon.crud.data.vo.ProdutoVO;
import com.DanielZambon.crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	private final ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public ProdutoVO Create(ProdutoVO produtoVO) {
		return null;
	}

}
