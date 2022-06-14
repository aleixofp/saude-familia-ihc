package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.entity.Endereco;
import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.entity.Paciente;
import br.com.ihc.projetosaudefamilia.entity.Pessoa;
import br.com.ihc.projetosaudefamilia.repository.PessoaRepository;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private CPFService cpfService;

    public boolean existePessoaComCpf(String cpf) {
        return this.pessoaRepository.existsByCpf(cpf);
    }

    public void salvar(PessoaVO pessoaVO) {
        var pessoa = pessoaVO.getPerfil().equalsIgnoreCase("PACIENTE") ? new Paciente() : new Medico();
        pessoa.setNome( pessoaVO.getNome() );
        pessoa.setCpf( cpfService.retirarMascara(pessoaVO.getCpf()) );
        pessoa.setEmail( pessoaVO.getEmail() );
        pessoa.setDataNascimento( pessoaVO.getDataNascimento() );
        pessoa.setTelefoneContato( pessoaVO.getTelefone() );

        var endereco = new Endereco();
        endereco.setBairro( pessoaVO.getEndereco().getBairro() );
        endereco.setCep( pessoaVO.getEndereco().getCep() );
        endereco.setCidade( pessoaVO.getEndereco().getLocalidade() );
        endereco.setComplemento( pessoaVO.getEndereco().getComplemento() );
        endereco.setLogradouro( pessoaVO.getEndereco().getLogradouro() );
        endereco.setEstado( pessoaVO.getEndereco().getUf() );
        endereco.setNumero( pessoaVO.getEndereco().getNumero() );

        pessoa.setEnderecoResidencia(endereco);
        endereco.setPessoaResidente(pessoa);

        this.pessoaRepository.save(pessoa);
    }
}
