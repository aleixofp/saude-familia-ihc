package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.exception.PessoaNaoEncontradaException;
import br.com.ihc.projetosaudefamilia.service.PacienteService;
import br.com.ihc.projetosaudefamilia.vo.FiltroListaPessoaVO;
import br.com.ihc.projetosaudefamilia.vo.PacienteVO;
import io.swagger.annotations.ApiOperation;
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
    public ResponseEntity<List<PacienteVO>> buscarPorRegiao(@RequestBody String regiao){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pacienteService.listarPorRegiao(regiao));
    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<PacienteVO> buscarPorId(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pacienteService.buscarPorId(id));
    }

    @PostMapping("/salvar")
    public ResponseEntity<PacienteVO> salvar(@RequestBody PacienteVO pacienteVO){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.pacienteService.salvar(pacienteVO));
    }

    @PutMapping("/atualizar")
    @ApiOperation(value = "Atualiza um paciente. O ID do paciente deve ser informado. Se não for informado o ID, será lançada uma exceção (PessoaNaoEncontradaException).")
    public ResponseEntity<PacienteVO> atualizar(@RequestBody PacienteVO pacienteVO) throws PessoaNaoEncontradaException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pacienteService.atualizar(pacienteVO));
    }

    @PostMapping("/listar")
    public ResponseEntity<List<PacienteVO>> listar(@RequestBody FiltroListaPessoaVO filtro){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pacienteService.listar(filtro));
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<PacienteVO>> listarTodos(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.pacienteService.listarTodos());
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?> excluir(@PathVariable("id") Long id){
        try {
            this.pacienteService.excluir(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }

    }

}
