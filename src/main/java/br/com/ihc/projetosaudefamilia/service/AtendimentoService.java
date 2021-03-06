package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.entity.Atendimento;
import br.com.ihc.projetosaudefamilia.entity.Medicamento;
import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.entity.Paciente;
import br.com.ihc.projetosaudefamilia.repository.AtendimentoRepository;
import br.com.ihc.projetosaudefamilia.repository.MedicamentoRepository;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoCompletoVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoFiltroVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoVO;
import br.com.ihc.projetosaudefamilia.vo.MedicamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public AtendimentoCompletoVO salvar(AtendimentoVO request) {
        var atendimento = new Atendimento();
        atendimento.setEmpregado(request.isEmpregado());
        atendimento.setEstadoAtualPaciente(request.getEstadoAtualPaciente());
        atendimento.setCondicoesSocioeconomicas(request.getCondicoesSocioeconomicas());
        atendimento.setDataAtendimento(request.getDataAtendimento());
        atendimento.setMedico(new Medico(request.getIdMedico()));
        atendimento.setPaciente(new Paciente(request.getIdPaciente()));
        atendimento.setAtivo(true);

        for (Long idM : request.getIdsMedicamentosAdministrados()) {
            var m = this.medicamentoRepository.findById(idM).orElse(null);
            if (m != null) {
                atendimento.getMedicamentosAdministrados().add(m);
            }
        }

        atendimento = this.atendimentoRepository.save(atendimento);

        return this.mapAtendimentoToAtendimentoCompletoVO(atendimento);

    }

    public List<AtendimentoCompletoVO> listar() {

        var atendimentos = this.atendimentoRepository.findAll();

        return atendimentos
                .stream()
                .map(this::mapAtendimentoToAtendimentoCompletoVO).toList();
    }

    public AtendimentoCompletoVO mapAtendimentoToAtendimentoCompletoVO(Atendimento atendimento){
        var atendimentoCompleto = new AtendimentoCompletoVO();
        atendimentoCompleto.setId(atendimento.getId());
        atendimentoCompleto.setCondicoesSocioeconomicas(atendimento.getCondicoesSocioeconomicas());
        atendimentoCompleto.setEstadoAtualPaciente(atendimento.getEstadoAtualPaciente());
        atendimentoCompleto.setEmpregado(atendimento.isEmpregado());
        atendimentoCompleto.setDataAtendimento(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(atendimento.getDataAtendimento()));
        atendimentoCompleto.setNomeMedico(atendimento.getMedico().getNome());
        atendimentoCompleto.setNomePaciente(atendimento.getPaciente().getNome());
        atendimentoCompleto.setIdMedico(atendimento.getMedico().getId());
        atendimentoCompleto.setIdPaciente(atendimento.getPaciente().getId());
        atendimentoCompleto.setAtivo(atendimento.isAtivo());

        atendimentoCompleto.setMedicamentos(atendimento.getMedicamentosAdministrados()
                .stream()
                .map(m -> {
                    var mVO = new MedicamentoVO();
                    mVO.setNome(m.getProduto());
                    mVO.setClasseTerapeutica(m.getClasseTerapeutica());
                    if (m.getPrincipioAtivo() != null){
                        mVO.setPrincipiosAtivos(Arrays.stream(m.getPrincipioAtivo().split(";")).toList());
                    }
                    mVO.setId(m.getId());
                    return mVO;
                })
                .collect(Collectors.toList()));

        return atendimentoCompleto;
    }

    public AtendimentoCompletoVO atualizar(AtendimentoVO request) {
        var atendimentoOpt = this.atendimentoRepository.findById(request.getId());
        if (atendimentoOpt.isPresent()){
            var atendimento = atendimentoOpt.get();
            atendimento.setEmpregado(request.isEmpregado());
            atendimento.setEstadoAtualPaciente(request.getEstadoAtualPaciente());
            atendimento.setCondicoesSocioeconomicas(request.getCondicoesSocioeconomicas());
            atendimento.setDataAtendimento(request.getDataAtendimento());
            atendimento.setMedico(new Medico(request.getIdMedico()));
            atendimento.setPaciente(new Paciente(request.getIdPaciente()));
            atendimento.setAtivo(true);

            atendimento.setMedicamentosAdministrados(new ArrayList<>());
            for (Long idM : request.getIdsMedicamentosAdministrados()) {
                var m = this.medicamentoRepository.findById(idM).orElse(null);
                if (m != null) {
                    atendimento.getMedicamentosAdministrados().add(m);
                }
            }

            atendimento = this.atendimentoRepository.save(atendimento);
            return this.mapAtendimentoToAtendimentoCompletoVO(atendimento);
        } else {
            throw new RuntimeException("Atendimento n??o encontrado");
        }
    }

    public AtendimentoCompletoVO buscarPorId(Long id) {
        var atendimentoOpt = this.atendimentoRepository.findById(id);
        if (atendimentoOpt.isPresent()){
            var atendimento = atendimentoOpt.get();
            return this.mapAtendimentoToAtendimentoCompletoVO(atendimento);
        } else {
            throw new RuntimeException("Atendimento n??o encontrado");
        }
    }

    public List<AtendimentoCompletoVO> buscarAtendimentosPorMedicoId(Long idMedico){
        var atendimentos = this.atendimentoRepository.findByMedicoId(idMedico);
        return atendimentos
                .stream()
                .map(this::mapAtendimentoToAtendimentoCompletoVO).toList();
    }

    public List<AtendimentoCompletoVO> buscarAtendimentosPorPacienteId(Long idPaciente){
        var atendimentos = this.atendimentoRepository.findByPacienteId(idPaciente);
        return atendimentos
                .stream()
                .map(this::mapAtendimentoToAtendimentoCompletoVO).toList();
    }

    @Transactional
    public void ativarInativar(Long id) {
        this.atendimentoRepository.ativarInativar(id);
    }
}
