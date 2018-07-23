package br.prova.zup.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.prova.zup.dto.PedidoDTO;
import br.prova.zup.model.Pedido;

@Mapper(componentModel = "spring", uses = {ClienteMapper.class, ProdutoMapper.class})
public interface PedidoMapper extends EntityMapper<PedidoDTO, Pedido> {

    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "produto.id", target = "produtoId")
    PedidoDTO toDto(Pedido pedido);

    @Mapping(source = "clienteId", target = "cliente")
    @Mapping(source = "produtoId", target = "produto")
    Pedido toEntity(PedidoDTO pedidoDTO);

    default Pedido fromId(Long id) {
        if (id == null) {
            return null;
        }
        Pedido pedido = new Pedido();
        pedido.setId(id);
        return pedido;
    }
}
