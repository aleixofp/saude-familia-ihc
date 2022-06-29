package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    List<Paciente> findByEnderecoResidenciaBairro(String bairro);

    List<Paciente> findByNomeOrCpf(String nome, String cpf);

    @Query("select distinct p from Paciente p join p.atendimentos a where a.medico.id = :idMedico order by a.dataAtendimento desc")
    List<Paciente> buscarAtendidosPorIdMedico(Long idMedico);

}
