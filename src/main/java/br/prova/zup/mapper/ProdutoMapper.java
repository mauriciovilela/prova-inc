package br.prova.zup.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.prova.zup.dto.ProdutoDTO;
import br.prova.zup.model.Produto;

@Mapper(componentModel = "spring", uses = {})
public interface ProdutoMapper extends EntityMapper<ProdutoDTO, Produto> {

//    @Mapping(target = "produtos", ignore = true)
    Produto toEntity(ProdutoDTO produtoDTO);

    default Produto fromId(Long id) {
        if (id == null) {
            return null;
        }
        Produto produto = new Produto();
        produto.setId(id);
        return produto;
    }
}
