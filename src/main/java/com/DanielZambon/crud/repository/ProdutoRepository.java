package com.DanielZambon.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DanielZambon.crud.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
