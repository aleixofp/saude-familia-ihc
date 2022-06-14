package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.CPFService;
import br.com.ihc.projetosaudefamilia.service.PessoaService;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
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
    public ResponseEntity<Boolean> validarCpf(@PathVariable("cpf") String cpf){
        try {
            var result = this.cpfService.validarCpf(cpf) && !this.pessoaService.existePessoaComCpf(cpf);
            return ResponseEntity
                    .ok(result);
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody PessoaVO pessoaVO){
        try {
            this.pessoaService.salvar(pessoaVO);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }



}
