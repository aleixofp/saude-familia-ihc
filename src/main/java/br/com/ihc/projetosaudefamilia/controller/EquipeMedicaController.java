package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.service.EquipeMedicaService;
import br.com.ihc.projetosaudefamilia.vo.CriarEquipeMedicaRequestVO;
import br.com.ihc.projetosaudefamilia.vo.EquipeMedicaCompletaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("equipe-medica")
public class EquipeMedicaController {

    @Autowired
    private EquipeMedicaService equipeMedicaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criar(@RequestBody CriarEquipeMedicaRequestVO request){
        this.equipeMedicaService.criar(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PostMapping("/buscar-equipes-por-id-medico")
    public ResponseEntity<List<EquipeMedicaCompletaVO>> buscarEquipesPorIdMedico(@RequestBody Long idMedico){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(equipeMedicaService.buscarEquipesPorIdMedico(idMedico));
    }

    @PostMapping("/buscar-equipes-por-regiao")
    public ResponseEntity<List<EquipeMedicaCompletaVO>> buscarEquipesPorRegiao(@RequestBody String regiao){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(equipeMedicaService.buscarEquipesPorRegiao(regiao));
    }

}
