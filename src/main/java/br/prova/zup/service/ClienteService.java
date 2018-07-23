package br.prova.zup.service;

import java.util.Optional;

import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prova.zup.dto.ClienteDTO;
import br.prova.zup.mapper.ClienteMapper;
import br.prova.zup.model.Cliente;
import br.prova.zup.repository.ClienteRepository;

@Service
@Transactional
public class ClienteService {

	private final ClienteRepository clienteRepository;
	private final ClienteMapper clienteMapper;
	private final CacheManager cacheManager;

	public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper, CacheManager cacheManager) {
		this.clienteRepository = clienteRepository;
		this.clienteMapper = clienteMapper;
		this.cacheManager = cacheManager;
	}

	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = clienteMapper.toEntity(clienteDTO);
		cliente = clienteRepository.save(cliente);
		limparCacheCliente();
		return clienteMapper.toDto(cliente);
	}

	@Transactional(readOnly = true)
	public Page<ClienteDTO> todos(Pageable pageable) {
		return clienteRepository.findAllBy(pageable).map(clienteMapper::toDto);
	}

	@Transactional(readOnly = true)
	public Optional<ClienteDTO> porId(Long id) {
		return clienteRepository.findById(id).map(clienteMapper::toDto);
	}

	private void limparCacheCliente() {
		cacheManager.getCache(ClienteRepository.TODOS_CLIENTES).clear();
	}

	public void excluir(Long id) {
		clienteRepository.deleteById(id);
		limparCacheCliente();
	}
	
}
