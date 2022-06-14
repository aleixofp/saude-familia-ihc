package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.entity.Atendimento;
import br.com.ihc.projetosaudefamilia.service.AtendimentoService;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoCompletoVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoFiltroVO;
import br.com.ihc.projetosaudefamilia.vo.AtendimentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(@RequestBody AtendimentoVO request){
        try {
            this.atendimentoService.salvar(request);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestBody AtendimentoFiltroVO request){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.atendimentoService.listar(request));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
