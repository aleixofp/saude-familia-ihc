package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.CEPService;
import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private CEPService cepService;

    @GetMapping("/consultar-cep/{cep}")
    @ApiOperation(value = "Consulta o CEP informado e retorna o endereço completo", response = EnderecoVO.class)
    public ResponseEntity<EnderecoVO> consultarCep(@PathVariable("cep") String cep) throws IOException {
        var result = this.cepService.consultarCEP(cep);
        return ResponseEntity
                .ok(result);
    }

}
