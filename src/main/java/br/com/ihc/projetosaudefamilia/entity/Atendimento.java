package br.com.ihc.projetosaudefamilia.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @SequenceGenerator(name = "atendimento_id_seq", sequenceName = "atendimento_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento_id_seq")
    private Long id;

    @Column(name = "tipo_atendimento")
    private String tipoAtendimento;

    @Column(name = "dt_atendimento")
    private Date dataAtendimento;

    @OneToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
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
}
