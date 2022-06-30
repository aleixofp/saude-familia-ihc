package br.com.ihc.projetosaudefamilia.mapper;

import br.com.ihc.projetosaudefamilia.entity.Medico;
import br.com.ihc.projetosaudefamilia.vo.MedicoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicoMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    public Medico map(MedicoVO medicoVO){
        var medico = new Medico();
        medico.setId(medicoVO.getId());
        medico.setNome(medicoVO.getNome());
        medico.setCpf(medicoVO.getCpf());
        medico.setEmail(medicoVO.getEmail());
        medico.setDataNascimento(medicoVO.getDataNascimento());
        medico.setTelefoneContato(medicoVO.getTelefone());
        medico.setEnderecoResidencia( enderecoMapper.map(medicoVO.getEndereco()) );
        medico.setSenha(medicoVO.getSenha());
        medico.setAtivo(medicoVO.isAtivo());
        return medico;
    }

    public List<Medico> mapToList(List<MedicoVO> medicoVOList){
        return medicoVOList
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public MedicoVO map(Medico medico){
        var medicoVO = new MedicoVO();
        medicoVO.setId(medico.getId());
        medicoVO.setNome(medico.getNome());
        medicoVO.setCpf(medico.getCpf());
        medicoVO.setEmail(medico.getEmail());
        medicoVO.setDataNascimento(medico.getDataNascimento());
        medicoVO.setTelefone(medico.getTelefoneContato());
        medicoVO.setEndereco( enderecoMapper.map(medico.getEnderecoResidencia()) );
        medicoVO.setSenha(medico.getSenha());
        medicoVO.setAtivo(medico.isAtivo());
        return medicoVO;
    }

    public List<MedicoVO> mapToListVO(List<Medico> medicoList){
        return medicoList
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }



}
