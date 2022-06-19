package br.com.ihc.projetosaudefamilia.mapper;

import br.com.ihc.projetosaudefamilia.entity.EquipeMedica;
import br.com.ihc.projetosaudefamilia.vo.EquipeMedicaCompletaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EquipeMedicaMapper {

    @Autowired
    private PessoaMapper pessoaMapper;

    public EquipeMedicaCompletaVO map(EquipeMedica em) {
        var vo = new EquipeMedicaCompletaVO();
        vo.setId(em.getId());
        vo.setRegiao(em.getRegiao());
        vo.setAtiva(em.isAtiva());
        vo.setDataCriacao(em.getDataCriacao());
        vo.setMedicos(em.getMedicos().stream().map(this.pessoaMapper::map).collect(Collectors.toList()));
        return vo;
    }

    public List<EquipeMedicaCompletaVO> map(List<EquipeMedica> emList){
        return emList.stream().map(this::map).collect(Collectors.toList());
    }

}
