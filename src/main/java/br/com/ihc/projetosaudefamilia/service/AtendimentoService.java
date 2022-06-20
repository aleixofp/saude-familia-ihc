package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.entity.Atendimento;
import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.entity.Paciente;
import br.com.ihc.projetosaudefamilia.repository.AtendimentoRepository;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoCompletoVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoFiltroVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    public void salvar(AtendimentoVO request) {
        var atendimento = new Atendimento();
        atendimento.setTipoAtendimento(request.getTipoAtendimento());
        atendimento.setDataAtendimento(request.getDataAtendimento());
        atendimento.setMedico(new Medico(request.getIdMedico()));
        atendimento.setPaciente(new Paciente(request.getIdPaciente()));

        this.atendimentoRepository.save(atendimento);
    }

    public List<AtendimentoCompletoVO> listar(AtendimentoFiltroVO request) {

        var atendimentos = request != null && request.getTipoAtendimento() != null && !request.getTipoAtendimento().isEmpty() ?
                this.atendimentoRepository.findAllByTipoAtendimento(request.getTipoAtendimento()) :
                this.atendimentoRepository.findAll();

        return atendimentos
                .stream()
                .map(atendimento -> {
                    var atendimentoCompleto = new AtendimentoCompletoVO();
                    atendimentoCompleto.setId(atendimento.getId());
                    atendimentoCompleto.setDataAtendimento(atendimento.getDataAtendimento());
                    atendimentoCompleto.setNomeMedico(atendimento.getMedico().getNome());
                    atendimentoCompleto.setNomePaciente(atendimento.getPaciente().getNome());
                    atendimentoCompleto.setIdMedico(atendimento.getMedico().getId());
                    atendimentoCompleto.setIdPaciente(atendimento.getPaciente().getId());
                    return atendimentoCompleto;
                }).toList();
    }
}
