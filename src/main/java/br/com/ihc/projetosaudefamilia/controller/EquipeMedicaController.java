package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.EquipeMedicaService;
import br.com.ihc.projetosaudefamilia.vo.CriarEquipeMedicaRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("equipe-medica")
public class EquipeMedicaController {

    @Autowired
    private EquipeMedicaService equipeMedicaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody CriarEquipeMedicaRequestVO request){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .build();
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/buscar-equipes-por-id-medico")
    public ResponseEntity<?> buscarEquipesPorIdMedico(@RequestBody Long idMedico){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(equipeMedicaService.buscarEquipesPorIdMedico(idMedico));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @PostMapping("/buscar-equipes-por-regiao")
    public ResponseEntity<?> buscarEquipesPorRegiao(@RequestBody String regiao){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(equipeMedicaService.buscarEquipesPorRegiao(regiao));
        } catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

}
