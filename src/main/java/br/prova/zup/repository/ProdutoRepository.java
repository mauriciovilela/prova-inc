package br.prova.zup.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import br.prova.zup.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
