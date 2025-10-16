package models;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

/**
 * Representa a un médico dentro del sistema de citas médicas.
 * Contiene su información básica, especialidad, consultorio y horario de atención.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class Medico {

    private int id;                        // Identificador único del médico
    private String nombre;                 // Nombre completo del médico
    private String especialidad;           // Especialidad médica (Ej: Cardiología, Pediatría)
    private String consultorio;            // Número o nombre del consultorio
    private Set<DayOfWeek> diasConsulta;   // Días de la semana en los que atiende (Ej: Lunes, Miércoles)
    private LocalTime horaInicio;          // Hora en la que inicia su jornada
    private LocalTime horaFin;             // Hora en la que termina su jornada

    /**
     * Constructor principal.
     * Crea un médico con toda su información, incluyendo días y horario de consulta.
     */
    public Medico(int id, String nombre, String especialidad, String consultorio,
                  Set<DayOfWeek> diasConsulta, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.consultorio = consultorio;
        this.diasConsulta = diasConsulta;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // --- Getters y Setters ---
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    public Set<DayOfWeek> getDiasConsulta() {
        return diasConsulta;
    }

    public void setDiasConsulta(Set<DayOfWeek> diasConsulta) {
        this.diasConsulta = diasConsulta;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    /**
     * Devuelve una representación en texto del médico.
     */
    @Override
    public String toString() {
        return "Medico{" +
                "nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", consultorio='" + consultorio + '\'' +
                ", diasConsulta=" + diasConsulta +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                '}';
    }
}
