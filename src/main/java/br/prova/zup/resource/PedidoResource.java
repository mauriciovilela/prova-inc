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

import br.prova.zup.dto.PedidoDTO;
import br.prova.zup.service.PedidoService;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/api")
public class PedidoResource {
	
	private final Logger log = LoggerFactory.getLogger(PedidoResource.class);
	
	private final PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/pedidos")
    @Timed
    public ResponseEntity<PedidoDTO> criar(@Valid @RequestBody PedidoDTO pedidoDTO) throws URISyntaxException {
        log.debug("Novo : {}", pedidoDTO);
        if (pedidoDTO.getId() != null) {
//            throw new BadRequestAlertException("A new pedido cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PedidoDTO result = pedidoService.save(pedidoDTO);
        return ResponseEntity.created(new URI("/api/pedidos/" + result.getId()))
            .body(result);
    }

    @PutMapping("/pedidos")
    @Timed
    public ResponseEntity<PedidoDTO> atualizar(@Valid @RequestBody PedidoDTO pedidoDTO) throws URISyntaxException {
        if (pedidoDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PedidoDTO result = pedidoService.save(pedidoDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    @GetMapping("/pedidos")
    @Timed
    public ResponseEntity<List<PedidoDTO>> todos(Pageable pageable) {
        Page<PedidoDTO> page = pedidoService.findAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/pedidos/{id}")
    @Timed
    public ResponseEntity<Optional<PedidoDTO>> porId(@PathVariable Long id) {
        Optional<PedidoDTO> pedidoDTO = pedidoService.findOne(id);
        return ResponseEntity.ok().body(pedidoDTO);
    }

    @DeleteMapping("/pedidos/{id}")
    @Timed
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        pedidoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
