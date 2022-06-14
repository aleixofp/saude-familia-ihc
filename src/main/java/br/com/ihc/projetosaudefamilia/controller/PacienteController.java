package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.PacienteService;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/buscar-por-regiao")
    public ResponseEntity<List<PessoaVO>> buscarPorRegiao(@RequestBody String regiao){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pacienteService.listarPorRegiao(regiao));
    }

}
