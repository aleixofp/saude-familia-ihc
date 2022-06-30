package br.com.ihc.projetosaudefamilia.repository;

import br.com.ihc.projetosaudefamilia.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    boolean existsByCpf(String cpf);

    Optional<Pessoa> findByEmail(String email);

    @Modifying
    @Query("update Pessoa p set p.isAtivo = case when p.isAtivo = true then false else true end where p.id = :id")
    void ativarInativar(Long id);
}
