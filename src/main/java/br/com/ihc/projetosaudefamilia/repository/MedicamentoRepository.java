package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

}
