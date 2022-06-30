package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findByMedicoId(Long idMedico);

    List<Atendimento> findByPacienteId(Long idPaciente);

    @Modifying
    @Query("update Atendimento a set a.isAtivo = case when a.isAtivo = true then false else true end where a.id = :id")
    void ativarInativar(Long id);
}
