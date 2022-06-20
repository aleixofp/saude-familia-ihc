package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.exception.PessoaNaoEncontradaException;
import br.com.ihc.projetosaudefamilia.service.MedicoService;
import br.com.ihc.projetosaudefamilia.vo.FiltroListaPessoaVO;
import br.com.ihc.projetosaudefamilia.vo.MedicoVO;
import br.com.ihc.projetosaudefamilia.vo.PacienteVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<MedicoVO> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.medicoService.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<MedicoVO> salvar(@RequestBody MedicoVO medicoVO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.medicoService.salvar(medicoVO));
    }

    @PutMapping("/atualizar")
    @ApiOperation(value = "Atualiza um médico. O ID do médico deve ser informado. Se não for informado o ID, será lançada uma exceção (PessoaNaoEncontradaException).")
    public ResponseEntity<MedicoVO> atualizar(@RequestBody MedicoVO medicoVO) throws PessoaNaoEncontradaException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.medicoService.atualizar(medicoVO));
    }

    @PostMapping("/listar")
    public ResponseEntity<List<MedicoVO>> listar(@RequestBody FiltroListaPessoaVO filtro){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.medicoService.listar(filtro));
    }

}
