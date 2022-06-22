package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.exception.EnderecoNaoEncontradoException;
import br.com.ihc.projetosaudefamilia.mapper.EnderecoMapper;
import br.com.ihc.projetosaudefamilia.repository.EnderecoRepository;
import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public EnderecoVO atualizar(EnderecoVO novoEndereco) throws EnderecoNaoEncontradoException {

        var entity = enderecoRepository.findById(novoEndereco.getId()).orElse(null);

        if(entity == null){
            throw new EnderecoNaoEncontradoException(novoEndereco.getId());
        }

        return enderecoMapper.map(entity);
    }


}
