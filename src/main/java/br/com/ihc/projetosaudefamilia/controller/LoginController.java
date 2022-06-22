package br.com.ihc.projetosaudefamilia.controller;

import br.com.ihc.projetosaudefamilia.exception.EmailNaoCadastradoException;
import br.com.ihc.projetosaudefamilia.service.LoginService;
import br.com.ihc.projetosaudefamilia.vo.LoginVO;
import br.com.ihc.projetosaudefamilia.vo.PessoaVO;
import br.com.ihc.projetosaudefamilia.vo.TentativaLoginException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/")
    @ApiOperation(value = "Autenticação por email e senha. Se o email não tiver cadastrado ou a senha/email não batem com o login, o status é BAD REQUEST.")
    public ResponseEntity<PessoaVO> login(@RequestBody LoginVO loginVO){
        try {
            PessoaVO pessoa = loginService.login(loginVO.getEmail(), loginVO.getSenha());
            return ResponseEntity.ok(pessoa);
        } catch (EmailNaoCadastradoException | TentativaLoginException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
