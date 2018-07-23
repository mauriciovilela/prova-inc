package br.prova.zup.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.prova.zup.dto.ProdutoDTO;
import br.prova.zup.mapper.ProdutoMapper;
import br.prova.zup.model.Produto;
import br.prova.zup.repository.ProdutoRepository;

@Service
@Transactional
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final ProdutoMapper produtoMapper;
    
	public ProdutoService(ProdutoRepository produtoRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.produtoMapper = produtoMapper;
    }
	
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Produto produto = produtoMapper.toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return produtoMapper.toDto(produto);
    }

    @Transactional(readOnly = true)
    public Page<ProdutoDTO> findAll(Pageable pageable) {
        return produtoRepository.findAll(pageable)
            .map(produtoMapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<ProdutoDTO> findOne(Long id) {
        return produtoRepository.findById(id)
            .map(produtoMapper::toDto);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
