package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.exception.PessoaNaoEncontradaException;
import br.com.ihc.projetosaudefamilia.mapper.MedicoMapper;
import br.com.ihc.projetosaudefamilia.repository.AtendimentoRepository;
import br.com.ihc.projetosaudefamilia.repository.EnderecoRepository;
import br.com.ihc.projetosaudefamilia.repository.MedicoRepository;
import br.com.ihc.projetosaudefamilia.vo.FiltroListaPessoaVO;
import br.com.ihc.projetosaudefamilia.vo.MedicoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private CPFService cpfService;

    public MedicoVO buscarPorId(Long id) {
        var medico = medicoRepository.findById(id).orElse(null);
        return medico != null ? this.medicoMapper.map(medico) : null;
    }

    public MedicoVO salvar(MedicoVO medicoVO) {
        var medico = this.medicoMapper.map(medicoVO);
        medico = medicoRepository.save(medico);
        return this.medicoMapper.map(medico);
    }

    public MedicoVO atualizar(MedicoVO medicoVO) throws PessoaNaoEncontradaException {
        var medico = this.medicoRepository.findById(medicoVO.getId()).orElse(null);
        if (medico != null) {
            medico = this.medicoMapper.map(medicoVO);
            return medicoMapper.map(this.medicoRepository.save(medico));
        } else {
            throw new PessoaNaoEncontradaException(String.format("Médico ID %d não encontrado", medicoVO.getId()));
        }
    }

    public List<MedicoVO> listar(FiltroListaPessoaVO filtro) {
        var pacientes = this.medicoRepository.findByNomeOrCpf(filtro.getNome(), cpfService.retirarMascara(filtro.getCpf()));
        return medicoMapper.mapToListVO(pacientes);
    }

    public List<MedicoVO> listarTodos() {
        var medicos = this.medicoRepository.findAll();
        return medicoMapper.mapToListVO(medicos);
    }

    public void excluir(Long id) {
        this.enderecoRepository.deleteByPessoaResidenteId(id);
        this.atendimentoRepository.deleteByMedicoId(id);
        this.medicoRepository.deleteById(id);
    }
}
