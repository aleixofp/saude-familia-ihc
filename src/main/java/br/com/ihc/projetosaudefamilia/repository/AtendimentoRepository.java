package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    List<Atendimento> findByMedicoId(Long idMedico);

    List<Atendimento> findByPacienteId(Long idPaciente);

    void deleteByPacienteId(Long idPaciente);

    void deleteByMedicoId(Long idMedico);
}
