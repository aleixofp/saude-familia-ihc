package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.repository.MedicamentoRepository;
import br.com.ihc.projetosaudefamilia.vo.MedicamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public List<MedicamentoVO> listar() throws IOException {
        return this.medicamentoRepository
                .findAll()
                .stream()
                .map(m -> {
                    var mVO = new MedicamentoVO();
                    mVO.setNome(m.getProduto());
                    mVO.setClasseTerapeutica(m.getClasseTerapeutica());
                    mVO.setPrincipiosAtivos(Arrays.stream(m.getPrincipioAtivo().split(";")).toList());
                    mVO.setId(m.getId());
                    return mVO;
                }).collect(Collectors.toList());
    }

}

