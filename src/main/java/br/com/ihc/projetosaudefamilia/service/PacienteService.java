package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.repository.PacienteRepository;
import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PessoaVO> listarPorRegiao(String regiao) {
        var pacientesNaRegiao = pacienteRepository.findByEnderecoResidenciaBairro(regiao);
        return pacientesNaRegiao.stream().map(paciente -> {
            var pessoa = new PessoaVO();
            pessoa.setId(paciente.getId());
            pessoa.setNome(paciente.getNome());
            pessoa.setCpf(paciente.getCpf());
            pessoa.setEmail(paciente.getEmail());
            pessoa.setDataNascimento(paciente.getDataNascimento());
            pessoa.setTelefone(paciente.getTelefoneContato());

            var endereco = new EnderecoVO();
            endereco.setBairro(paciente.getEnderecoResidencia().getBairro());
            endereco.setCep(paciente.getEnderecoResidencia().getCep());
            endereco.setLocalidade(paciente.getEnderecoResidencia().getCidade());
            endereco.setComplemento(paciente.getEnderecoResidencia().getComplemento());
            endereco.setLogradouro(paciente.getEnderecoResidencia().getLogradouro());
            endereco.setUf(paciente.getEnderecoResidencia().getEstado());
            endereco.setNumero(paciente.getEnderecoResidencia().getNumero());

            pessoa.setEndereco(endereco);

            return pessoa;
        }).collect(Collectors.toList());
    }

}
