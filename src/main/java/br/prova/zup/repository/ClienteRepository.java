package br.prova.zup.repository;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.prova.zup.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	String TODOS_CLIENTES = "todosClientes";

	@Cacheable(cacheNames = TODOS_CLIENTES)
	Page<Cliente> findAllBy(Pageable pageable);

}
