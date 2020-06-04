package com.gabriellopesjds.vendasweb.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabriellopesjds.vendasweb.domain.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}
