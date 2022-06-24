package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.MedicamentoService;
import br.com.ihc.projetosaudefamilia.vo.MedicamentoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<MedicamentoVO>> listar(){
        try {
            return ResponseEntity
                    .ok(this.medicamentoService.listar());
        } catch (IOException e){
            e.printStackTrace();
            return ResponseEntity
                    .badRequest()
                    .build();
        }
    }

}
