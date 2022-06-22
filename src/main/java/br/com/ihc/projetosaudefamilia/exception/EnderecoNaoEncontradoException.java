package br.com.ihc.projetosaudefamilia.exception;

public class EnderecoNaoEncontradoException extends Throwable {
    public EnderecoNaoEncontradoException(Long id) {
        super("Endereço não encontrado com o id: " + id);
    }
}
