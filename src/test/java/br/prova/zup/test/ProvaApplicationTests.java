package br.prova.zup.test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import br.prova.zup.model.Cliente;
import br.prova.zup.repository.ClienteRepository;
import br.prova.zup.resource.ClienteResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProvaApplicationTests {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	private final Logger log = LoggerFactory.getLogger(ClienteResource.class);
	
	@Test
	@Transactional
	public void executar() {
		Cliente item = new Cliente();
		item.setCidade("UBERLANDIA");
		item.setUf("MG");
		item.setNome("MAURICIO");
		ZonedDateTime data = ZonedDateTime.now(ZoneId.systemDefault());
		item.setDataNascimento(data);
		log.info("TESTE : {}", item);
		clienteRepository.save(item);
	}

}
