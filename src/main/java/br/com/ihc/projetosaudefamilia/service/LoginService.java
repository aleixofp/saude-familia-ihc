package br.com.ihc.projetosaudefamilia.service;

import br.com.ihc.projetosaudefamilia.exception.EmailNaoCadastradoException;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import br.com.ihc.projetosaudefamilia.vo.TentativaLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private PessoaService pessoaService;

    public PessoaVO login(String email, String senha) throws EmailNaoCadastradoException, TentativaLoginException {

        PessoaVO pessoa = pessoaService.buscarPorEmail(email);

        if(pessoa != null && pessoa.getSenha().equals(senha)){
            return pessoa;
        } else {
            throw new TentativaLoginException("Email ou senha inválidos");
        }
    }

}
