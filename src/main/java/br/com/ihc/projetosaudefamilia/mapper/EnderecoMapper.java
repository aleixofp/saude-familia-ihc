package br.com.ihc.projetosaudefamilia.mapper;

import br.com.ihc.projetosaudefamilia.entity.Endereco;
import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public Endereco map(EnderecoVO enderecoVO) {
        var endereco = new Endereco();
        endereco.setBairro( enderecoVO.getBairro() );
        endereco.setCep( enderecoVO.getCep() );
        endereco.setCidade( enderecoVO.getLocalidade() );
        endereco.setComplemento( enderecoVO.getComplemento() );
        endereco.setLogradouro( enderecoVO.getLogradouro() );
        endereco.setEstado( enderecoVO.getUf() );
        endereco.setNumero( enderecoVO.getNumero() );
        return endereco;
    }

    public EnderecoVO map(Endereco endereco) {
        var enderecoVO = new EnderecoVO();
        enderecoVO.setBairro(endereco.getBairro());
        enderecoVO.setCep(endereco.getCep());
        enderecoVO.setLocalidade(endereco.getCidade());
        enderecoVO.setComplemento(endereco.getComplemento());
        enderecoVO.setLogradouro(endereco.getLogradouro());
        enderecoVO.setUf(endereco.getEstado());
        return enderecoVO;
    }

}
