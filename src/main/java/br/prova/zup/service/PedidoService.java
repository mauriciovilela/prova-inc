package br.prova.zup.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prova.zup.dto.PedidoDTO;
import br.prova.zup.mapper.PedidoMapper;
import br.prova.zup.model.Pedido;
import br.prova.zup.repository.PedidoRepository;

@Service
@Transactional
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final PedidoMapper pedidoMapper;
    
	public PedidoService(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
    }
	
    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = pedidoMapper.toEntity(pedidoDTO);
        pedido = pedidoRepository.save(pedido);
        return pedidoMapper.toDto(pedido);
    }

    @Transactional(readOnly = true)
    public Page<PedidoDTO> findAll(Pageable pageable) {
        return pedidoRepository.findAll(pageable)
            .map(pedidoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<PedidoDTO> findOne(Long id) {
        return pedidoRepository.findById(id)
            .map(pedidoMapper::toDto);
    }

    public void delete(Long id) {
        pedidoRepository.deleteById(id);
    }
}
