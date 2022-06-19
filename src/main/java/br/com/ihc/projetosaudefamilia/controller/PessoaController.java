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
    @ApiOperation(value = "A validação é feita em duas etapas: primeiro valida se o CPF está correto, utilizando do algoritmo; e em segundo valida se o CPF já foi cadastrado para uma outra pessoa.")
    public ResponseEntity<Boolean> validarCpf(@PathVariable("cpf") String cpf){
        var result = this.cpfService.validarCpf(cpf) && !this.pessoaService.existePessoaComCpf(cpf);
        return ResponseEntity
                .ok(result);
    }

    @PostMapping("/salvar")
    @ApiOperation(value = "Se enviar o ID, atualizará o dado no banco de dados. Se não enviar o ID, criará um novo registro.")
    public ResponseEntity<?> salvar(@RequestBody PessoaVO pessoaVO){
        this.pessoaService.salvar(pessoaVO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }



}
