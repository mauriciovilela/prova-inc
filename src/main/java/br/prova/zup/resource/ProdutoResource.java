package br.prova.zup.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.prova.zup.dto.ProdutoDTO;
import br.prova.zup.service.ProdutoService;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/api")
public class ProdutoResource {
	
	private final Logger log = LoggerFactory.getLogger(ProdutoResource.class);
	
	private final ProdutoService produtoService;

    public ProdutoResource(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/produtos")
    @Timed
    public ResponseEntity<ProdutoDTO> criar(@Valid @RequestBody ProdutoDTO produtoDTO) throws URISyntaxException {
        log.debug("Novo : {}", produtoDTO);
        ProdutoDTO result = produtoService.save(produtoDTO);
        return ResponseEntity.created(new URI("/api/produtos/" + result.getId()))
            .body(result);
    }

    @PutMapping("/produtos")
    @Timed
    public ResponseEntity<ProdutoDTO> atualizar(@Valid @RequestBody ProdutoDTO produtoDTO) throws URISyntaxException {
        ProdutoDTO result = produtoService.save(produtoDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    @GetMapping("/produtos")
    @Timed
    public ResponseEntity<List<ProdutoDTO>> todos(Pageable pageable) {
        Page<ProdutoDTO> page = produtoService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/produtos/{id}")
    @Timed
    public ResponseEntity<Optional<ProdutoDTO>> porId(@PathVariable Long id) {
        Optional<ProdutoDTO> produtoDTO = produtoService.findOne(id);
        return ResponseEntity.ok().body(produtoDTO);
    }

    @DeleteMapping("/produtos/{id}")
    @Timed
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        produtoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
