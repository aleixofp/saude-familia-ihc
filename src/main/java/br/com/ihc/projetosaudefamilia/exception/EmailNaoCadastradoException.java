package br.com.ihc.projetosaudefamilia.exception;

public class EmailNaoCadastradoException extends Throwable {
    public EmailNaoCadastradoException(String email) {
        super(String.format("Email %s não cadastrado", email));
    }
}
