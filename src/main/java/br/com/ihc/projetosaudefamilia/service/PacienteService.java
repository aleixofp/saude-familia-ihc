package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.mapper.EnderecoMapper;
import br.com.ihc.projetosaudefamilia.mapper.PessoaMapper;
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

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private EnderecoMapper enderecoMapper;

    public List<PessoaVO> listarPorRegiao(String regiao) {
        var pacientesNaRegiao = pacienteRepository.findByEnderecoResidenciaBairro(regiao);
        return pacientesNaRegiao.stream().map(paciente -> {
            var pessoa = this.pessoaMapper.map(paciente);
            var endereco = this.enderecoMapper.map(paciente.getEnderecoResidencia());

            pessoa.setEndereco(endereco);

            return pessoa;
        }).collect(Collectors.toList());
    }

    public PessoaVO buscarPorId(Long id) {
        var paciente = pacienteRepository.findById(id).orElse(null);

        if (paciente != null) {
            var pessoa = this.pessoaMapper.map(paciente);
            var endereco = this.enderecoMapper.map(paciente.getEnderecoResidencia());

            pessoa.setEndereco(endereco);

            return pessoa;
        } else {
            return null;
        }
    }
}
