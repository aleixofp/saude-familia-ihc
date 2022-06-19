package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.entity.Endereco;
import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.entity.Paciente;
import br.com.ihc.projetosaudefamilia.entity.Pessoa;
import br.com.ihc.projetosaudefamilia.mapper.EnderecoMapper;
import br.com.ihc.projetosaudefamilia.mapper.PessoaMapper;
import br.com.ihc.projetosaudefamilia.repository.PessoaRepository;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CPFService cpfService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public boolean existePessoaComCpf(String cpf) {
        return this.pessoaRepository.existsByCpf(cpf);
    }

    public void salvar(PessoaVO pessoaVO) {

        if (pessoaVO.getId() != null){
            var pessoaOpt = this.pessoaRepository.findById(pessoaVO.getId());

            if (pessoaOpt.isPresent()){
                var pessoa =  this.pessoaMapper.map(pessoaVO);

                var endereco = this.enderecoMapper.map( pessoaVO.getEndereco() );

                pessoa.setEnderecoResidencia(endereco);
                endereco.setPessoaResidente(pessoa);

                this.pessoaRepository.save(pessoa);
            } else {
                this.novo(pessoaVO);
            }
        } else {
            this.novo(pessoaVO);
        }
    }

    private void novo(PessoaVO pessoaVO){
        var pessoa = pessoaVO.getPerfil().equalsIgnoreCase("PACIENTE") ? new Paciente() : new Medico();
        pessoa.setNome( pessoaVO.getNome() );
        pessoa.setCpf( cpfService.retirarMascara(pessoaVO.getCpf()) );
        pessoa.setEmail( pessoaVO.getEmail() );
        pessoa.setDataNascimento( pessoaVO.getDataNascimento() );
        pessoa.setTelefoneContato( pessoaVO.getTelefone() );

        var endereco = this.enderecoMapper.map(pessoaVO.getEndereco());

        pessoa.setEnderecoResidencia(endereco);
        endereco.setPessoaResidente(pessoa);
        this.pessoaRepository.save(pessoa);
    }
}
