package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.exception.EnderecoNaoEncontradoException;
import br.com.ihc.projetosaudefamilia.service.CEPService;
import br.com.ihc.projetosaudefamilia.service.EnderecoService;
import br.com.ihc.projetosaudefamilia.vo.EnderecoVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("endereco")
public class EnderecoController {

    @Autowired
    private CEPService cepService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping("/consultar-cep/{cep}")
    @ApiOperation(value = "Consulta o CEP informado e retorna o endereço completo")
    public ResponseEntity<EnderecoVO> consultarCep(@PathVariable("cep") String cep) throws IOException {
        var result = this.cepService.consultarCEP(cep);
        return ResponseEntity
                .ok(result);
    }

    @PutMapping("/atualizar")
    @ApiOperation(value = "Atualiza o endereço informado. O ID no body é obrigatório, caso não enviar é bad request. Se o endereço não existir na base, é bad request.")
    public ResponseEntity<EnderecoVO> atualizar(@RequestBody EnderecoVO endereco) {
        if (endereco.getId() == null){
            return ResponseEntity.badRequest().build();
        }
        try {
            var result = this.enderecoService.atualizar(endereco);
            return ResponseEntity
                    .ok(result);
        } catch (EnderecoNaoEncontradoException e){
            return ResponseEntity.badRequest().build();
        }

    }

}
