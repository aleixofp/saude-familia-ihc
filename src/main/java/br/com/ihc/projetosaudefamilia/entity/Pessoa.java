package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public abstract class Pessoa {

    @Id
    @SequenceGenerator(name = "pessoa_id_seq", sequenceName = "pessoa_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_id_seq")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    @Column(name = "dt_nascimento")
    private Date dataNascimento;

    @Column(name = "telefone_contato")
    private String telefoneContato;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_endereco_residencia")
    private Endereco enderecoResidencia;

    @Column(name = "senha")
    private String senha;

    @Column(name = "dt_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao = new Date();

    @Column(name = "is_ativo")
    private boolean isAtivo = true;

    public Pessoa(){

    }

    public Pessoa(Long id){
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public Endereco getEnderecoResidencia() {
        return enderecoResidencia;
    }

    public void setEnderecoResidencia(Endereco enderecoResidencia) {
        this.enderecoResidencia = enderecoResidencia;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }
}
