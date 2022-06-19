package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.entity.EquipeMedica;
import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.mapper.EquipeMedicaMapper;
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

    @Autowired
    private EquipeMedicaMapper equipeMedicaMapper;

    public void criar(CriarEquipeMedicaRequestVO request) {
        var equipeMedica = new EquipeMedica();
        equipeMedica.setMedicos(request.getIdsMedicos().stream().map(Medico::new).collect(Collectors.toList()));
        equipeMedica.setRegiao(request.getRegiao().toUpperCase());
        equipeMedicaRepository.save(equipeMedica);
    }

    public List<EquipeMedicaCompletaVO> buscarEquipesPorIdMedico(Long idMedico) {
        var retorno = equipeMedicaRepository.findAllByMedicoId(idMedico);
        return this.equipeMedicaMapper.map(retorno);
    }

    public List<EquipeMedicaCompletaVO> buscarEquipesPorRegiao(String regiao) {
        var retorno = equipeMedicaRepository.findAllByRegiao(regiao.toUpperCase());
        return this.equipeMedicaMapper.map(retorno);
    }

}
