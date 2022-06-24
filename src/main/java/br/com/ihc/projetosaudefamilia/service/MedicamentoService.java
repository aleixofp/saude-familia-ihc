package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.vo.MedicamentoJsonVO;
import br.com.ihc.projetosaudefamilia.vo.MedicamentoVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicamentoService {

    public List<MedicamentoVO> listar() throws IOException {
        try {
            File file = ResourceUtils.getFile("classpath:medicamentos.json");

            try (InputStream is = new FileInputStream(file)){
                var medsArr = new ObjectMapper().readValue(is.readAllBytes(), MedicamentoJsonVO[].class);
                var medsJson = Arrays.asList(medsArr);

                return medsJson
                        .stream()
                        .map(mj -> {
                            var medVO = new MedicamentoVO();
                            medVO.setNome(mj.getProduto());
                            medVO.setClasseTerapeutica(mj.getClasseTerapeutica());
                            if (mj.getPrincipioAtivo() != null && !mj.getPrincipioAtivo().isEmpty()){
                                medVO.setPrincipiosAtivos(Arrays.asList(mj.getPrincipioAtivo().split(";")));
                            }
                            return medVO;
                        }).collect(Collectors.toList());
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

}

