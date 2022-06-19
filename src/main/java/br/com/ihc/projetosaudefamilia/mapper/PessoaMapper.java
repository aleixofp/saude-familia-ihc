package br.com.ihc.projetosaudefamilia.mapper;

import br.com.ihc.projetosaudefamilia.entity.Pessoa;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper {

    public PessoaVO map(Pessoa pessoa) {
        var vo = new PessoaVO();
        vo.setId(pessoa.getId());
        vo.setNome(pessoa.getNome());
        vo.setCpf(pessoa.getCpf());
        vo.setEmail(pessoa.getEmail());
        vo.setDataNascimento(pessoa.getDataNascimento());
        vo.setTelefone(pessoa.getTelefoneContato());
        vo.setPerfil(pessoa.getTipo());
        return vo;
    }

    public Pessoa map(PessoaVO pessoaVO) {
        var pessoa = new Pessoa();
        pessoa.setId(pessoaVO.getId());
        pessoa.setNome(pessoaVO.getNome());
        pessoa.setCpf(pessoaVO.getCpf());
        pessoa.setEmail(pessoaVO.getEmail());
        pessoa.setDataNascimento(pessoaVO.getDataNascimento());
        pessoa.setTelefoneContato(pessoaVO.getTelefone());
        return pessoa;
    }

}
