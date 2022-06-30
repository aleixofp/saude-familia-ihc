package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.exception.EmailNaoCadastradoException;
import br.com.ihc.projetosaudefamilia.mapper.EnderecoMapper;
import br.com.ihc.projetosaudefamilia.repository.PessoaRepository;
import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public boolean existePessoaComCpf(String cpf) {
        return this.pessoaRepository.existsByCpf(cpf);
    }

    public PessoaVO buscarPorEmail(String email) throws EmailNaoCadastradoException {
        var entity = this.pessoaRepository.findByEmail(email).orElse(null);

        if (entity == null){
            throw new EmailNaoCadastradoException(email);
        }

        var vo = new PessoaVO();
        vo.setId(entity.getId());
        vo.setNome(entity.getNome());
        vo.setCpf(entity.getCpf());
        vo.setEmail(entity.getEmail());
        vo.setSenha(entity.getSenha());
        vo.setDataNascimento(entity.getDataNascimento());
        vo.setTelefone(entity.getTelefoneContato());
        vo.setAtivo(entity.isAtivo());

        var enderecoVO = this.enderecoMapper.map(entity.getEnderecoResidencia());
        vo.setEndereco(enderecoVO);

        return vo;

    }

    @Transactional
    public void ativarInativar(Long id) {
        this.pessoaRepository.ativarInativar(id);
    }
}
