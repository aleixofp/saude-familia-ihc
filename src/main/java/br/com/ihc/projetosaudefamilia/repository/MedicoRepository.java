package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    List<Medico> findByNomeOrCpf(String nome, String cpf);
}
