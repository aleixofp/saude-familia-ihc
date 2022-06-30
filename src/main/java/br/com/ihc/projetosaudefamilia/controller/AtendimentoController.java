package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.entity.Atendimento;
import br.com.ihc.projetosaudefamilia.service.AtendimentoService;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoCompletoVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoFiltroVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody AtendimentoVO request){
        try {
            var result = this.atendimentoService.salvar(request);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/atualizar")
    public ResponseEntity<?> atualizar(@RequestBody AtendimentoVO request){
        try {
            var result = this.atendimentoService.atualizar(request);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }

    }

    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable("id") Long id){
        try {
            var result = this.atendimentoService.buscarPorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/buscar-por-medico/{id}")
    public ResponseEntity<?> buscarPorMedico(@PathVariable("id") Long id){
        try {
            var result = this.atendimentoService.buscarAtendimentosPorMedicoId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/buscar-por-paciente/{id}")
    public ResponseEntity<?> buscarPorPaciente(@PathVariable("id") Long id){
        try {
            var result = this.atendimentoService.buscarAtendimentosPorPacienteId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(result);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/listar-todos")
    public ResponseEntity<List<AtendimentoCompletoVO>> buscar(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.atendimentoService.listar());
    }

    @GetMapping("/ativar-inativar/{id}")
    public ResponseEntity<?> ativarInativar(@PathVariable("id") Long id){
        try {
            this.atendimentoService.ativarInativar(id);
            return ResponseEntity
                    .status(HttpStatus.OK).build();
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
