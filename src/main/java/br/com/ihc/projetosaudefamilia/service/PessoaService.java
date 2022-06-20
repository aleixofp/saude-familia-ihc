package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public boolean existePessoaComCpf(String cpf) {
        return this.pessoaRepository.existsByCpf(cpf);
    }

}
