package models;

/**
 * Representa a un paciente dentro del sistema de citas médicas.
 * Contiene los datos básicos como número de seguridad social, nombre, teléfono y dirección.
 * 
 * @author Daniel Miramontes Iribe (00000252801)
 */
public class Paciente {

    private int numeroSeguridadSocial; // Identificador único del paciente (NSS)
    private String nombre;             // Nombre completo del paciente
    private String telefono;           // Teléfono de contacto
    private String direccion;          // Dirección de residencia

    /**
     * Constructor principal con todos los datos.
     * Se usa al recuperar un paciente existente de la base de datos o al crear uno completo.
     */
    public Paciente(int numeroSeguridadSocial, String nombre, String telefono, String direccion) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Getters y Setters para acceder o modificar los datos del paciente.

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

    /**
     * Devuelve una representación en texto del paciente.
     */
    @Override
    public String toString() {
        return "Paciente{" +
                "numeroSeguridadSocial=" + numeroSeguridadSocial +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
