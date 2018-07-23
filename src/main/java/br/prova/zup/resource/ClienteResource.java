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

import br.prova.zup.dto.ClienteDTO;
import br.prova.zup.service.ClienteService;
import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/api")
public class ClienteResource {
	
	private final Logger log = LoggerFactory.getLogger(ClienteResource.class);
	
	private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/clientes")
    @Timed
    public ResponseEntity<ClienteDTO> criar(@Valid @RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        log.debug("Novo : {}", clienteDTO);
        if (clienteDTO.getId() != null) {
//            throw new BadRequestAlertException("A new cliente cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ClienteDTO result = clienteService.salvar(clienteDTO);
        return ResponseEntity.created(new URI("/api/clientes/" + result.getId()))
            .body(result);
    }

    @PutMapping("/clientes")
    @Timed
    public ResponseEntity<ClienteDTO> atualizar(@Valid @RequestBody ClienteDTO clienteDTO) throws URISyntaxException {
        if (clienteDTO.getId() == null) {
//            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ClienteDTO result = clienteService.salvar(clienteDTO);
        return ResponseEntity.ok()
            .body(result);
    }

    @GetMapping("/clientes")
    @Timed
    public ResponseEntity<List<ClienteDTO>> todos(Pageable pageable) {
        Page<ClienteDTO> page = clienteService.todos(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/clientes/{id}")
    @Timed
    public ResponseEntity<Optional<ClienteDTO>> porId(@PathVariable Long id) {
        Optional<ClienteDTO> clienteDTO = clienteService.porId(id);
        return ResponseEntity.ok().body(clienteDTO);
    }

    @DeleteMapping("/clientes/{id}")
    @Timed
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        clienteService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
