package br.com.ihc.projetosaudefamilia.mapper;

import br.com.ihc.projetosaudefamilia.entity.Paciente;
import br.com.ihc.projetosaudefamilia.vo.PacienteVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PacienteMapper {

    @Autowired
    private EnderecoMapper enderecoMapper;

    public Paciente map(PacienteVO pessoaVO) {
        var paciente = new Paciente();
        paciente.setId(pessoaVO.getId());
        paciente.setNome(pessoaVO.getNome());
        paciente.setCpf(pessoaVO.getCpf());
        paciente.setEmail(pessoaVO.getEmail());
        paciente.setDataNascimento(pessoaVO.getDataNascimento());
        paciente.setTelefoneContato(pessoaVO.getTelefone());
        paciente.setEnderecoResidencia( enderecoMapper.map(pessoaVO.getEndereco()) );
        paciente.setSenha(pessoaVO.getSenha());
        return paciente;
    }

    public List<Paciente> mapToList(List<PacienteVO> pacienteVOList){
        return pacienteVOList
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

    public PacienteVO map(Paciente paciente){
        var pacienteVO = new PacienteVO();
        pacienteVO.setId(paciente.getId());
        pacienteVO.setNome(paciente.getNome());
        pacienteVO.setCpf(paciente.getCpf());
        pacienteVO.setEmail(paciente.getEmail());
        pacienteVO.setDataNascimento(paciente.getDataNascimento());
        pacienteVO.setTelefone(paciente.getTelefoneContato());
        pacienteVO.setEndereco( enderecoMapper.map(paciente.getEnderecoResidencia()) );
        pacienteVO.setSenha(paciente.getSenha());
        return pacienteVO;
    }

    public List<PacienteVO> mapToListVO(List<Paciente> pacienteList){
        return pacienteList
                .stream()
                .map(this::map)
                .collect(Collectors.toList());
    }

}
