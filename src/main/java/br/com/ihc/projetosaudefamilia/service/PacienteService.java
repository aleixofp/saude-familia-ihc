package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.exception.PessoaNaoEncontradaException;
import br.com.ihc.projetosaudefamilia.mapper.PacienteMapper;
import br.com.ihc.projetosaudefamilia.repository.PacienteRepository;
import br.com.ihc.projetosaudefamilia.vo.FiltroListaPessoaVO;
import br.com.ihc.projetosaudefamilia.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Autowired
    private CPFService cpfService;

    public List<PacienteVO> listarPorRegiao(String regiao) {
        var pacientesNaRegiao = pacienteRepository.findByEnderecoResidenciaBairro(regiao);
        return pacientesNaRegiao.stream().map(paciente -> this.pacienteMapper.map(paciente)).collect(Collectors.toList());
    }

    public PacienteVO buscarPorId(Long id) {
        var paciente = pacienteRepository.findById(id).orElse(null);
        return paciente != null ? this.pacienteMapper.map(paciente) : null;
    }

    public PacienteVO salvar(PacienteVO pacienteVO) {
        var paciente = this.pacienteMapper.map(pacienteVO);
        paciente = pacienteRepository.save(paciente);
        return this.pacienteMapper.map(paciente);
    }

    public PacienteVO atualizar(PacienteVO pacienteVO) throws PessoaNaoEncontradaException {
        var paciente = this.pacienteRepository.findById(pacienteVO.getId()).orElse(null);
        if (paciente != null) {
            var pessoa = this.pacienteMapper.map(pacienteVO);
            return pacienteMapper.map(this.pacienteRepository.save(pessoa));
        } else {
            throw new PessoaNaoEncontradaException(String.format("Paciente ID %d não encontrado", pacienteVO.getId()));
        }
    }

    public List<PacienteVO> listar(FiltroListaPessoaVO filtro) {
        var pacientes = this.pacienteRepository.findByNomeOrCpf(filtro.getNome(), cpfService.retirarMascara(filtro.getCpf()));
        return pacienteMapper.mapToListVO(pacientes);
    }

    public List<PacienteVO> listarTodos() {
        var pacientes = this.pacienteRepository.findAll();
        return pacienteMapper.mapToListVO(pacientes);
    }

    public void excluir(Long id) {
        this.pacienteRepository.deleteById(id);
    }
}
