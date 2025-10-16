package models.dto;

/**
 * Data Transfer Object (DTO) para la entidad Paciente.
 *
 * Funcionalidad principal:
 * - Permite transportar información de un paciente entre capas (modelo, controlador, vista)
 *   sin exponer la entidad completa.
 * - Contiene información básica del paciente: NSS, nombre, teléfono y dirección.
 *
 * Uso:
 *  - Mostrar datos del paciente en la interfaz.
 *  - Validar o seleccionar pacientes al registrar citas.
 *  - Evitar manipular directamente la entidad Paciente en capas externas.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class PacienteDTO {

    private int numeroSeguridadSocial;
    private String nombre;
    private String telefono;
    private String direccion;

    public PacienteDTO() {
    }

    public PacienteDTO(int numeroSeguridadSocial, String nombre, String telefono, String direccion) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(int numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        // Representación simple para mostrar en listas o menús
        return nombre + " (" + numeroSeguridadSocial + ")";
    }
}
