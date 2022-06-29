package br.com.ihc.projetosaudefamilia.entity;

import br.com.ihc.projetosaudefamilia.enums.TipoAtendimentoEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @SequenceGenerator(name = "atendimento_id_seq", sequenceName = "atendimento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento_id_seq")
    private Long id;

    @Column(name = "dt_atendimento")
    @Temporal(TemporalType.DATE)
    private Date dataAtendimento;

    @Column(name = "dt_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "condicoes_socioeconomicas")
    private String condicoesSocioeconomicas;

    @Column(name = "estado_atual_paciente")
    private String estadoAtualPaciente;

    @Column(name = "is_empregado")
    private boolean empregado;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "atendimento_medicamento",
            joinColumns = @JoinColumn(name = "id_atendimento"),
            inverseJoinColumns = @JoinColumn(name = "id_medicamento"))
    private List<Medicamento> medicamentosAdministrados = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getCondicoesSocioeconomicas() {
        return condicoesSocioeconomicas;
    }

    public void setCondicoesSocioeconomicas(String condicoesSocioeconomicas) {
        this.condicoesSocioeconomicas = condicoesSocioeconomicas;
    }

    public String getEstadoAtualPaciente() {
        return estadoAtualPaciente;
    }

    public void setEstadoAtualPaciente(String estadoAtualPaciente) {
        this.estadoAtualPaciente = estadoAtualPaciente;
    }

    public boolean isEmpregado() {
        return empregado;
    }

    public void setEmpregado(boolean empregado) {
        this.empregado = empregado;
    }

    public List<Medicamento> getMedicamentosAdministrados() {
        return medicamentosAdministrados;
    }

    public void setMedicamentosAdministrados(List<Medicamento> medicamentosAdministrados) {
        this.medicamentosAdministrados = medicamentosAdministrados;
    }
}
