package br.prova.zup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.prova.zup.dto.ClienteDTO;
import br.prova.zup.model.Cliente;

@Mapper(componentModel = "spring", uses = {})
public interface ClienteMapper extends EntityMapper<ClienteDTO, Cliente> {

//    @Mapping(target = "clientes", ignore = true)
    Cliente toEntity(ClienteDTO clienteDTO);

    default Cliente fromId(Long id) {
        if (id == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setId(id);
        return cliente;
    }
}
