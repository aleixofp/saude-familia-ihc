package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.EquipeMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface EquipeMedicaRepository extends JpaRepository<EquipeMedica, Long> {

    @Query("select em from EquipeMedica em join em.medicos m where m.id = :idMedico")
    List<EquipeMedica> findAllByMedicoId(Long idMedico);

    List<EquipeMedica> findAllByRegiao(String regiao);
}
