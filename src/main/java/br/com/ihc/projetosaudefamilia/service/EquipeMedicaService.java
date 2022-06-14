package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.entity.EquipeMedica;
import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.repository.EquipeMedicaRepository;
import br.com.ihc.projetosaudefamilia.vo.CriarEquipeMedicaRequestVO;
import br.com.ihc.projetosaudefamilia.vo.EquipeMedicaCompletaVO;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class EquipeMedicaService {

    @Autowired
    private EquipeMedicaRepository equipeMedicaRepository;

    public void criar(CriarEquipeMedicaRequestVO request) {
        var equipeMedica = new EquipeMedica();
        equipeMedica.setMedicos(request.getIdsMedicos().stream().map(Medico::new).collect(Collectors.toList()));
        equipeMedica.setRegiao(request.getRegiao().toUpperCase());
        equipeMedicaRepository.save(equipeMedica);
    }

    public List<EquipeMedicaCompletaVO> buscarEquipesPorIdMedico(Long idMedico) {
        return equipeMedicaRepository.findAllByMedicoId(idMedico).stream()
                .map(em -> {
                    var equipeMedicaCompletaVO = new EquipeMedicaCompletaVO();
                    equipeMedicaCompletaVO.setId(em.getId());
                    equipeMedicaCompletaVO.setRegiao(em.getRegiao());
                    equipeMedicaCompletaVO.setMedicos(em.getMedicos().stream().map(m -> {
                        var medicoVO = new PessoaVO();
                        medicoVO.setId(m.getId());
                        medicoVO.setNome(m.getNome());
                        medicoVO.setCpf(m.getCpf());
                        medicoVO.setEmail(m.getEmail());
                        medicoVO.setDataNascimento(m.getDataNascimento());
                        medicoVO.setTelefone(m.getTelefoneContato());
                        return medicoVO;
                    }).collect(Collectors.toList()));
                    return equipeMedicaCompletaVO;
                }).collect(Collectors.toList());
    }

    public List<EquipeMedicaCompletaVO> buscarEquipesPorRegiao(String regiao) {
        return equipeMedicaRepository.findAllByRegiao(regiao.toUpperCase()).stream()
                .map(em -> {
                    var equipeMedicaCompletaVO = new EquipeMedicaCompletaVO();
                    equipeMedicaCompletaVO.setId(em.getId());
                    equipeMedicaCompletaVO.setRegiao(em.getRegiao());
                    equipeMedicaCompletaVO.setMedicos(em.getMedicos().stream().map(m -> {
                        var medicoVO = new PessoaVO();
                        medicoVO.setId(m.getId());
                        medicoVO.setNome(m.getNome());
                        medicoVO.setCpf(m.getCpf());
                        medicoVO.setEmail(m.getEmail());
                        medicoVO.setDataNascimento(m.getDataNascimento());
                        medicoVO.setTelefone(m.getTelefoneContato());
                        return medicoVO;
                    }).collect(Collectors.toList()));
                    return equipeMedicaCompletaVO;
                }).collect(Collectors.toList());
    }

}
