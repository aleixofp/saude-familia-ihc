package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.CPFService;
import br.com.ihc.projetosaudefamilia.service.PessoaService;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private CPFService cpfService;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/validar-cpf/{cpf}")
    @ApiOperation(value = "Valida o CPF informado. A validação é em duas etapas: primeiro valida se o CPF está correto, utilizando do algoritmo; e em segundo valida se o CPF já foi cadastrado para uma outra pessoa.", response = Boolean.class)
    public ResponseEntity<Boolean> validarCpf(@PathVariable("cpf") String cpf){
        var result = this.cpfService.validarCpf(cpf) && !this.pessoaService.existePessoaComCpf(cpf);
        return ResponseEntity
                .ok(result);
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody PessoaVO pessoaVO){
        this.pessoaService.salvar(pessoaVO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }



}
