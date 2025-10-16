package models;

import java.time.LocalDateTime;

/**
 * Representa una cita médica en el sistema.
 * Contiene la información del paciente, médico, fecha/hora y motivo de la cita.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class Cita {

    private int id;                  // Identificador único de la cita
    private Paciente paciente;       // Paciente que solicitó la cita
    private Medico medico;           // Médico asignado a la cita
    private LocalDateTime fechaHora; // Fecha y hora exacta de la cita
    private String motivo;           // Motivo o descripción breve de la consulta

    /**
     * Constructor principal con ID.
     * Se utiliza cuando la cita ya está registrada en el sistema.
     */
    public Cita(int id, Paciente paciente, Medico medico, LocalDateTime fechaHora, String motivo) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    /**
     * Constructor alternativo sin ID.
     * Se usa cuando la cita aún no ha sido persistida o registrada formalmente.
     */
    public Cita(Paciente paciente, Medico medico, LocalDateTime fechaHora, String motivo) {
        this.paciente = paciente;
        this.medico = medico;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
    }

    // --- Getters y Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Devuelve una representación textual de la cita.
     */
    @Override
    public String toString() {
        return "Cita{" +
                "paciente=" + paciente +
                ", medico=" + medico +
                ", fechaHora=" + fechaHora +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
